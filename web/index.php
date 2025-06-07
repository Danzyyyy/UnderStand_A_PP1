<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Tiket</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        .menu-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            width: 300px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 200px auto;
        }

        button {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            font-size: 16px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>

<body>
<div class="menu-container">
    <h1>Menu Tiket</h1>
    <button onclick="window.location.href='tiket.php'">Tampilkan Semua Tiket</button>
    <button onclick="window.location.href='tiketExecutive.php'">Tampilkan Tiket Executive</button>
    <button onclick="window.location.href='tiketBusiness.php'">Tampilkan Tiket Businesss</button>
    <button onclick="window.location.href='tiketEconomy.php'">Tampilkan Tiket Economy</button>

</div>
</body>

</html>