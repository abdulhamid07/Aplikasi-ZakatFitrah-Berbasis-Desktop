-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 05 Jul 2017 pada 18.47
-- Versi Server: 5.5.27
-- Versi PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `db_zakat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_mustahiq`
--

CREATE TABLE IF NOT EXISTS `dt_mustahiq` (
  `nomor` int(11) NOT NULL,
  `tglInput` char(10) NOT NULL,
  `gol` varchar(20) NOT NULL,
  `namaMustahiq` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `ket` text NOT NULL,
  `jmlUang` int(11) NOT NULL,
  `jmlBeras` int(11) NOT NULL,
  `panitia` varchar(20) NOT NULL,
  PRIMARY KEY (`nomor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_mustahiq`
--

INSERT INTO `dt_mustahiq` (`nomor`, `tglInput`, `gol`, `namaMustahiq`, `alamat`, `ket`, `jmlUang`, `jmlBeras`, `panitia`) VALUES
(1, '05-07-2017', 'AMILIN', 'AHMAD', 'SIDOMULYO', '', 40000, 1, 'hamid'),
(3, '05-07-2017', 'AMILIN', 'ABDUL HAMID', 'Bantul', '', 40000, 1, 'hamid');

--
-- Trigger `dt_mustahiq`
--
DROP TRIGGER IF EXISTS `update_after_mustahiq`;
DELIMITER //
CREATE TRIGGER `update_after_mustahiq` AFTER INSERT ON `dt_mustahiq`
 FOR EACH ROW update log_muzakki set currDate=new.tglInput,
totalUang=totalUang-new.jmlUang,
totalBeras=totalBeras-new.jmlBeras
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dt_muzakki`
--

CREATE TABLE IF NOT EXISTS `dt_muzakki` (
  `nomor` int(11) NOT NULL,
  `tglInput` char(10) NOT NULL,
  `namaMuzakki` varchar(30) NOT NULL,
  `Alamat` text NOT NULL,
  `jmlJiwa` int(11) NOT NULL,
  `jmlZakat` int(11) NOT NULL,
  `jmlBeras` int(11) NOT NULL,
  `panitia` varchar(30) NOT NULL,
  PRIMARY KEY (`nomor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dt_muzakki`
--

INSERT INTO `dt_muzakki` (`nomor`, `tglInput`, `namaMuzakki`, `Alamat`, `jmlJiwa`, `jmlZakat`, `jmlBeras`, `panitia`) VALUES
(0, '05-07-2017', 'MASUD ALHAFIZ', 'Imogiri', 3, 60000, 0, 'hamid'),
(1, '05-07-2017', 'ABDUL HAMID', 'BANTUL', 5, 80000, 1, 'hamid'),
(2, '05-07-2017', 'ENDRA SETIAWAN', 'wonosari', 3, 40000, 1, 'hamid'),
(4, '05-07-2017', 'SARWAN HAMID', 'Manding', 4, 20000, 3, 'hamid'),
(5, '05-07-2017', 'RIFAN ARDIANSYAH', 'manding', 3, 20000, 2, 'hamid');

--
-- Trigger `dt_muzakki`
--
DROP TRIGGER IF EXISTS `update_log_muzakki`;
DELIMITER //
CREATE TRIGGER `update_log_muzakki` AFTER INSERT ON `dt_muzakki`
 FOR EACH ROW update log_muzakki set currDate=new.tglInput,
totalUang=totalUang+new.jmlZakat,
totalBeras=totalBeras+new.jmlBeras
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `log_muzakki`
--

CREATE TABLE IF NOT EXISTS `log_muzakki` (
  `currDate` varchar(10) NOT NULL,
  `totalUang` int(9) NOT NULL,
  `totalBeras` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `log_muzakki`
--

INSERT INTO `log_muzakki` (`currDate`, `totalUang`, `totalBeras`) VALUES
('05-07-2017', 20000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nmLengkap` varchar(25) NOT NULL,
  `usrName` varchar(20) NOT NULL,
  `psw` varchar(100) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`idUser`, `nmLengkap`, `usrName`, `psw`, `email`) VALUES
(1, 'Abdul Hamid', 'hamid', 'hamid', 'hamyd.abdul6@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
