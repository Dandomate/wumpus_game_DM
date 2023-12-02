-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Dec 02. 19:07
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `wumpus_game`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `game_states`
--

CREATE TABLE `game_states` (
  `id` int(11) NOT NULL,
  `username` text DEFAULT NULL,
  `game_state` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `game_states`
--

INSERT INTO `game_states` (`id`, `username`, `game_state`) VALUES
(89, 'asd', '10 C 7 S 1 0\nWWWWWWWWWW\nW___P____W\nWUGP_____W\nW________W\nW__P_____W\nW________W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(91, 'kalacs', '10 D 6 E 2 0\nWWWWWWWWWW\nW___P____W\nWUGP_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(92, 'marcsa', '10 F 7 E 0 0\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW________W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(95, 'mateka', '10 C 5 S 2 1\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(96, 'zsolt', '10 C 3 N 0 1\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW________W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(97, 'Mateora', '10 C 4 S 0 1\nWWWWWWWWWW\nW___P____W\nW__P_____W\nW________W\nW__P_____W\nW________W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(98, 'uborca', '10 E 7 E 2 1\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(99, 'alma', '10 C 6 S 1 1\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW________W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(100, 'kuvasz', '10 D 7 W 2 0\nWWWWWWWWWW\nW___P____W\nWUGP_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(101, 'bogarka', '10 C 5 N 2 0\nWWWWWWWWWW\nW___P____W\nWUGP_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n'),
(102, 'username', '10 E 7 E 2 1\nWWWWWWWWWW\nW___P____W\nWU_P_____W\nW________W\nW__P_____W\nW____U___W\nW____X___W\nW________W\nW___P____W\nWWWWWWWWWW\n');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `game_states`
--
ALTER TABLE `game_states`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `game_states`
--
ALTER TABLE `game_states`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
