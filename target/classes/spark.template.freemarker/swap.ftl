<!DOCTYPE html>

<head>
    <title>Box Office | Exchange</title>
</head>

<body>
    <#if complete??>
        <#if success??>
            <h1>Exchange was successful!</h1>

        <#elseif purchaseFail??>
            <h1>Sorry! We don't have enough tickets to fulfill your exchange</h1>

        <#else>
            <h1>Oops! Looks like you're trying to return more tickets than we offer</h1>
        </#if>
        <br/>
        <a href="/">Back home...</a>
    <#else>

        <h2>Please specify the number of tickets you wish to exchange, as well
        as what screen your original tickets were for and what screen you wish
        to exchange for.</h2>

        <form action="/swap/submit" method="post">
            <label for="numTix">Number of Tickets: </label>
            <input type="number" id="numTix" name="numTix">
            <br/>
            <label for="returnScreen">Exchange From: </label>
            <select id="returnScreen" name="returnScreen">
                <option value=0>Screen #1</option>
                <option value=1>Screen #2</option>
                <option value=2>Screen #3</option>
                <option value=3>Screen #4</option>
                <option value=4>Screen #5</option>
            </select>
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