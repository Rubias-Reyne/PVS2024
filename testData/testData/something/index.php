<?php
$name = isset($_COOKIE['student_name']) ? htmlspecialchars($_COOKIE['student_name']) : null;
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zadani jmen</title>
</head>
<body>
    <h1>Hello cookie example</h1>

    <?php if ($name): ?>
        <p>Hello, <strong><?php echo $name; ?></strong></p>
        <form action="set_name.php" method="POST">
            <button type="submit" name="clear">Reset</button>
        </form>
    <?php else: ?>
        <p>Můžete zadat své jméno, stránka si ho bude chvilku 'pamatovat':</p>
        <form action="set_name.php" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <button type="submit">Submit</button>
        </form>
    <?php endif; ?>
</body>
</html>

