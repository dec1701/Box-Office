package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken after the user has specified what screen(s) they
 * want reports for. Its purpose is to collect and display the necessary
 * information from the Model
 */
public class GetReportRoute implements Route {

	// Freemarker Template Engine - fills in and render a .ftl file
	private TemplateEngine templateEngine;

	// Controller class - responsible for managing information btwn Model and View
	private Sales sales;

	/**
	 * Constructor - creates a new instance of GetReportRoute
	 * @param templateEngine - the template engine used to render .ftl files
	 * @param sales - the Controller class for communicating with the model
	 */
	public GetReportRoute(TemplateEngine templateEngine, Sales sales){

		this.templateEngine = templateEngine;
		this.sales = sales;
	}

	/**
	 * Performs this route's operations:
	 *      Set session values according to whether or not user must give info
	 * 	    Put info to be displayed in the Map
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		// Getting the user's session
		Session httpSession = request.session();

		// The map of values to fill in to the .ftl file
		Map<String, Object> model = new HashMap<>();

		// If the user needs to provide info for the report
		if(httpSession.attribute("reporting").equals(1)){
			// reset this session value so it will not trigger on this route again
			httpSession.attribute("reporting", 0);

			// set this session value so it will trigger when the user comes
			// back to this route
			httpSession.attribute("reportComplete", 1);

			return templateEngine.render(new ModelAndView(model, "report.ftl"));
		}
		// If the user has provided info for the report
		else if(httpSession.attribute("reportComplete").equals(1)){
			// reset this session value so it will not trigger on this route again
			httpSession.attribute("reportComplete", 0);

			// lets the .ftl file know which html to display
			model.put("print", 1);

			// getting the number screen that the user wants a report on
			// a -1 means the user wants a comprehensive report
			int screenNum = httpSession.attribute("screenNum");

			// this session value is no longer needed
			httpSession.removeAttribute("screenNum");

			// Comprehensive report, put all the screens' info in the map
			if(screenNum == -1){
				model.put("s0Sales", sales.getSales(0));
				model.put("s1Sales", sales.getSales(1));
				model.put("s2Sales", sales.getSales(2));
				model.put("s3Sales", sales.getSales(3));
				model.put("s4Sales", sales.getSales(4));

				model.put("s0Remain", sales.getRemaining(0));
				model.put("s1Remain", sales.getRemaining(1));
				model.put("s2Remain", sales.getRemaining(2));
				model.put("s3Remain", sales.getRemaining(3));
				model.put("s4Remain", sales.getRemaining(4));

				System.out.println(sales.report());
			}
			// report on one screen, put only its info in the map
			else{
				model.put("screenNum", screenNum + 1);
				model.put("sales", sales.getSales(screenNum));
				model.put("remain", sales.getRemaining(screenNum));
				System.out.println(sales.report(screenNum));
			}

			return templateEngine.render(new ModelAndView(model, "report.ftl"));
		}

		// set this session value so it will trigger when the user comes
		// back to this route
		httpSession.attribute("reporting", 1);
		response.redirect("/report");
		return null;
	}
}
