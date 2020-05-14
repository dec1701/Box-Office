<!DOCTYPE html>

<head>
    <title>Box Office | Purchase</title>
</head>

<body>
    <#if complete??>
        <h1>Thank you for your purchase!</h1>
    <#else>

        <h2>Please specify the number of tickets for your purchase and select a screen.</h2>

        <form>
            <input type="number" id="numTix" name="numTix">
        </form>

        <form action="/confirm?screenNum=0" method="post">
            <button type="submit" formmethod="post">Screen #1</button>
        </form>

        <form action="/confirm?screenNum=1" method="post">
            <button type="submit" formmethod="post">Screen #2</button>
        </form>

        <form action="/confirm?screenNum=2" method="post">
            <button type="submit" formmethod="post">Screen #3</button>
        </form>

        <form action="/confirm?screenNum=3" method="post">
            <button type="submit" formmethod="post">Screen #4</button>
        </form>

        <form action="/confirm?screenNum=4" method="post">
            <button type="submit" formmethod="post">Screen #5</button>
        </form>

</body>