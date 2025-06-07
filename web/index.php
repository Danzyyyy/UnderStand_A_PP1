<!DOCTYPE html>
<html lang="id">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Menu Tiket</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Segoe+UI:wght@400;600&display=swap');

        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f4f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .menu-container {
            background: white;
            padding: 40px 30px;
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 30px;
            font-size: 1.8rem;
        }

        .menu-button {
            display: block;
            width: 100%;
            margin: 12px 0;
            padding: 12px 0;
            font-size: 1rem;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 25px;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.2s ease;
            cursor: pointer;
        }

        .menu-button:hover {
            background-color: #2980b9;
            transform: translateY(-2px);
        }

        .menu-button:active {
            transform: scale(0.98);
        }
    </style>
</head>

<body>
    <div class="menu-container">
        <h1>Menu Tiket</h1>
        <button class="menu-button" onclick="window.location.href='tiket.php'">Tampilkan Semua Tiket</button>
        <button class="menu-button" onclick="window.location.href='tiket_executive.php'">Tiket Executive</button>
        <button class="menu-button" onclick="window.location.href='tiket_business.php'">Tiket Business</button>
        <button class="menu-button" onclick="window.location.href='tiket_economy.php'">Tiket Economy</button>
    </div>
</body>

</html>