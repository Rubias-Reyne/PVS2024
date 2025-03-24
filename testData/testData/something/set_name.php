<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['name'])) {
        setcookie('student_name', $_POST['name'], time() + 86400, "/");
    } elseif (isset($_POST['clear'])) {
        setcookie('student_name', '', time() - 3600, "/");
    }
}
header("Location: index.php");
exit;
