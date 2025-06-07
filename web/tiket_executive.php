<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <title>Daftar Tiket Executive</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f4f8;
            margin: 0;
        }

        .container {
            padding: 20px;
            max-width: 1000px;
            margin: 0 auto;
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        h1 {
            color: #2c3e50;
            font-size: 2rem;
            margin: 0 auto;
            text-align: center;
            flex-grow: 1;
        }

        a.button-back {
            text-decoration: none;
            background: #2980b9;
            color: white;
            padding: 10px 20px;
            border-radius: 25px;
            font-weight: 600;
            transition: background-color 0.3s ease;
            font-size: 0.9rem;
        }

        a.button-back:hover {
            background: #1f6391;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 25px;
        }

        .card {
            background: white;
            border-radius: 15px;
            padding: 20px 25px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.12);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            display: flex;
            flex-direction: column;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
        }

        .card h2 {
            margin: 0 0 10px 0;
            font-size: 1.5rem;
            color: #2980b9;
        }

        .card p {
            margin: 6px 0;
            color: #34495e;
            font-size: 0.95rem;
        }

        .label {
            font-weight: 600;
            color: #7f8c8d;
            width: 80px;
            display: inline-block;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="top-bar">
            <a href="index.php" class="button-back">← Kembali</a>
            <h1>Halaman Daftar Tiket Executive</h1>
        </div>

        <?php
        $file = 'data/daftar_tiket.csv';

        if (!file_exists($file) || !is_readable($file)) {
            echo "<p style='color: red; text-align: center;'>Error: File <strong>" . htmlspecialchars($file) . "</strong> tidak ditemukan atau tidak dapat dibaca.</p>";
        } else {
            if (($handle = fopen($file, 'r')) !== FALSE) {
                $header = fgetcsv($handle);
                $executiveFound = false;

                if ($header) {
                    echo '<div class="cards">';

                    while (($data = fgetcsv($handle)) !== FALSE) {
                        $row = array_combine($header, $data);

                        if (isset($row['Tipe']) && strtolower(trim($row['Tipe'])) === 'executive') {
                            $executiveFound = true;

                            echo '<div class="card">';

                            if (isset($row['Nama'])) {
                                echo '<h2>' . htmlspecialchars($row['Nama']) . '</h2>';
                            }

                            foreach ($row as $key => $value) {
                                if ($key === 'Nama') continue;
                                echo '<p><span class="label">' . htmlspecialchars($key) . ':</span> ' . htmlspecialchars($value) . '</p>';
                            }

                            echo '</div>';
                        }
                    }

                    echo '</div>';

                    if (!$executiveFound) {
                        echo "<p style='text-align:center; color:#999;'>Tidak ada tiket bertipe Executive ditemukan.</p>";
                    }
                } else {
                    echo "<p>File CSV kosong atau tidak valid.</p>";
                }

                fclose($handle);
            } else {
                echo "<p>Gagal membuka file daftar tiket.</p>";
            }
        }
        ?>
    </div>
</body>

</html>