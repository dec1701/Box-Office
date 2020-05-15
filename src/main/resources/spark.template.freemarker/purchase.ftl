<!DOCTYPE html>

<head>
    <title>Box Office | Purchase</title>
</head>

<body>
    <#if complete??>
        <#if success??>
            <h1>Thank you for your purchase!</h1>

        <#else>
            <h1>Sorry! We don't have enough tickets to fulfill your purchase</h1>
        </#if>
        <br/>
        <a href="/">Back home...</a>
    <#else>

        <h2>Please specify the number of tickets for your purchase and select a screen.</h2>

        <form action="/confirm" method="post">
            <label for="numTix">Number of Tickets: </label>
            <input type="number" id="numTix" name="numTix">
            <br/>
            <button type="submit" formmethod="post" id="screenNum" name="screenNum" value=0>Screen #1</button>
            <br/>
            Number of Tickets Left: ${s0Remain}
            <br/>
            <button type="submit" formmethod="post" id="screenNum" name="screenNum" value=1>Screen #2</button>
            <br/>
            Number of Tickets Left: ${s1Remain}
            <br/>
            <button type="submit" formmethod="post" id="screenNum" name="screenNum" value=2>Screen #3</button>
            <br/>
            Number of Tickets Left: ${s2Remain}
            <br/>
            <button type="submit" formmethod="post" id="screenNum" name="screenNum" value=3>Screen #4</button>
            <br/>
            Number of Tickets Left: ${s3Remain}
            <br/>
            <button type="submit" formmethod="post" id="screenNum" name="screenNum" value=4>Screen #5</button>
            <br/>
            Number of Tickets Left: ${s4Remain}
        </form>
    </#if>

</body>