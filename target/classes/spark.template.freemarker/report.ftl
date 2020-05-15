<!DOCTYPE html>

<head>
    <title>Box Office | Report</title>
</head>

<body>
    <#if print??>
        <#if screenNum??>
            <h2>Tickets sold for Screen #${screenNum}:</h2>
            <h2>${sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${remain}</h2>
        <#else>
            <h2>Tickets sold for Screen #1:</h2>
            <h2>${s0Sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${s0Remain}</h2>
            <br/>

            <h2>Tickets sold for Screen #2:</h2>
            <h2>${s1Sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${s2Remain}</h2>
            <br/>

            <h2>Tickets sold for Screen #3:</h2>
            <h2>${s2Sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${s2Remain}</h2>
            <br/>

            <h2>Tickets sold for Screen #4:</h2>
            <h2>${s3Sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${s3Remain}</h2>
            <br/>

            <h2>Tickets sold for Screen #5:</h2>
            <h2>${s4Sales}</h2>
            <h2>Tickets remaining:</h2>
            <h2>${s4Remain}</h2>
            <br/>
        </#if>

        <a href="/end">End the day...</a>

    <#else>

        <h2>Please select a screen</h2>

        <form action="/report/print?screenNum=-1" method="post">
            <button type="submit" formmethod="post">All Screens</button>
        </form>

        <form action="/report/print?screenNum=0" method="post">
            <button type="submit" formmethod="post">Screen #1</button>
        </form>

        <form action="/report/print?screenNum=1" method="post">
            <button type="submit" formmethod="post">Screen #2</button>
        </form>

        <form action="/report/print?screenNum=2" method="post">
            <button type="submit" formmethod="post">Screen #3</button>
        </form>

        <form action="/report/print?screenNum=3" method="post">
            <button type="submit" formmethod="post">Screen #4</button>
        </form>

        <form action="/report/print?screenNum=4" method="post">
            <button type="submit" formmethod="post">Screen #5</button>
        </form>
    </#if>
</body>