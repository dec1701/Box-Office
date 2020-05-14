<!DOCTYPE html>

<head>
    <title>Box Office | Report</title>
</head>

<body>
    <#if print??>
        <h1>${report}</h1>
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