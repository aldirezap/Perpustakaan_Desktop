/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.11-MariaDB : Database - perpus_smansagas
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`perpus_smansagas` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `perpus_smansagas`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

insert  into `admin`(`username`,`password`) values 
('admin','admin'),
('iimnurmini','12345');

/*Table structure for table `anggota` */

DROP TABLE IF EXISTS `anggota`;

CREATE TABLE `anggota` (
  `id_anggota` varchar(20) NOT NULL,
  `nama_anggota` varchar(25) NOT NULL,
  `nis` varchar(25) NOT NULL,
  `jk_anggota` varchar(15) NOT NULL,
  `telp_anggota` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` enum('Pinjam','Tidak pinjam') NOT NULL,
  PRIMARY KEY (`id_anggota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `anggota` */

insert  into `anggota`(`id_anggota`,`nama_anggota`,`nis`,`jk_anggota`,`telp_anggota`,`alamat`,`status`) values 
('AGT001','Yasir','111132070001150087','Laki-laki','08532145698','Kuningan','Pinjam'),
('AGT002','Aldi','111132070001150010','Laki-laki','0853214554','Banjar','Tidak pinjam'),
('AGT003','Wilona','111132070001150064','Perempuan','08532145654','Cimaragas','Tidak pinjam'),
('AGT004','Aziz','111132070001150019','Laki-laki','085321456','Kuningan','Tidak pinjam'),
('AGT005','Fakhri','111132070001150076','Laki-laki','085214563','Cirebon','Tidak pinjam'),
('AGT006','Rendra','111132070001150099','Laki-laki','0814745698','Majalengka','Tidak pinjam'),
('AGT007','Chika ','111132070001150020','Perempuan','089654756','Cimaragas','Tidak pinjam'),
('AGT008','Michael San','111132070001150043','Laki-laki','083214565','Banjar','Pinjam'),
('AGT009','Yana Musdalifa','111132070001150022','Perempuan','0853332654','Ciamis','Tidak pinjam'),
('AGT010','Ernawati','111132070001150090','Perempuan','085321456','Ciamis','Pinjam'),
('AGT011','Syifa Azkia','111132070001150012','Perempuan','08533214569','Cimaragas','Tidak pinjam'),
('AGT012','Firhan Dzikri Zaelani','111132070001150015','Laki-laki','085444745698','Cimaragas','Tidak pinjam'),
('AGT013','Marsya Najla Raisa','111132070001150019','Perempuan','085456987','Cimaragas','Tidak pinjam'),
('AGT014','Aal Alifa Nugraha ','111132070001150026','Perempuan','085221456','Cimaragas','Tidak pinjam'),
('AGT015','Aditia Hidayat','111132070001150028','Laki-laki','0832145654','Cimaragas','Tidak pinjam'),
('AGT016','Ayudhia Zahira','111132070001150050','Perempuan','085321564852','Cimaragas','Pinjam'),
('AGT017','Faizal Septiana','111132070001150053','Laki-laki','089456879521','Cimaragas','Tidak pinjam'),
('AGT018','Hidayatur Rohman','111132070001150056','Laki-laki','084563215','Cimaragas','Tidak pinjam'),
('AGT019','Iyan Sofyan','111132070001150058','Laki-laki','085203125036','Cimaragas','Tidak pinjam'),
('AGT020','Relsa Syindanis','111132070001150062','Laki-laki','084562125456','Banjar','Tidak pinjam'),
('AGT021','Fika Nadila Izzatunnisa','111132070001150001','Perempuan','08545652145','Banjar','Tidak pinjam'),
('AGT022','Desan Nurhasanah','111132070001150004','Perempuan','08532145698','Banjar','Tidak pinjam'),
('AGT023','Maftuh Ikhsan','111132070001160012','Laki-laki','08542321456','Banjar','Tidak pinjam'),
('AGT024','Fikri Heriyawan','111132070001150014','Laki-laki','0854565421','Ciamis','Tidak pinjam'),
('AGT025','Karina Nurul Arifah','111132070001150018','Perempuan','08522321456','Ciamis','Tidak pinjam'),
('AGT026','Shity Meyra Zahratul Muna','111132070001150034','Perempuan','08536547897','Cimaragas','Tidak pinjam'),
('AGT027','Angga Agustiana','111132070001150049','Laki-laki','08987854565','Cimaragas','Tidak pinjam'),
('AGT028','Siti Reina Nurliana','111132070001150035','Perempuan','083123456789','Ciamis','Tidak pinjam'),
('AGT029','Dika Guntara','111132070001150052','Laki-laki','087456123025','Ciamis','Tidak pinjam'),
('AGT030','Maemunah','111132070001150059','Perempuan','08532111414','Banjar','Pinjam'),
('AGT031','Siti','111132070001150059','Perempuan','0853214565','Cimaragas','Tidak pinjam'),
('AGT032','Asep Maulana','111132070001150033','Laki-laki','0854456512','Cimaragas','Pinjam');

/*Table structure for table `buku` */

DROP TABLE IF EXISTS `buku`;

CREATE TABLE `buku` (
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `tahun_terbit` int(4) NOT NULL,
  `penulis` varchar(25) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`kode_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `buku` */

insert  into `buku`(`kode_buku`,`judul`,`penerbit`,`tahun_terbit`,`penulis`,`kategori`,`isbn`,`jumlah`) values 
('BK001','Matematika','Gramedia',2020,'Alding','Pelajaran','12254789',19),
('BK002','Sejarah','Gramedia',2020,'Reza','Pelajaran','214587',29),
('BK003','Biologi','Bio Media',2018,'Alex','Pelajaran','2214565',27),
('BK004','Dilan','Pastel Books',2014,'Pidi Baiq','Novel','',20),
('BK005','Geografi IX','Book Media',2021,'Dra. Eva banowati','Pelajaran','2024568',38),
('BK006','Akuntansi Pengantar 1','Gava Media',2009,'Supardi','Pelajaran','978-979-107-882-5',29),
('BK007','Pengantar Teknologi Informasi','Andi Offset',2014,'Tata Sutabri','Pelajaran','979-970-886-9',20),
('BK008','Pengolahan Citra Digital : Konsep dan Teori','Andi Offset	',2013,'Fajar Astuti Hermawati	','Pelajaran','978-979–293-119-8',28),
('BK009','Smart Creativepreneur','Andi Offset',2013,'Ari Kurnia','Motivasi','978-979-293-475-5',39),
('BK010','TEOLOGI KONSTITUSI','LKiS',2015,'Adam Muhshi','Teori','978-602-0809-04-5',19),
('BK011','Cara mudah berfilsafat','Ar-Ruzz Media',2016,'Nicholas Fearn','Penelitian','978-979-254-647-7',40),
('BK012','Soe Hok Gie','Ar-Ruzz Media',2016,'Muhammad Rifai','Biografi','978-979-254-726-9',20),
('BK013','Antropologi Al-Qur’an','LKIS',2013,'Baidhowi','Teori','978-979-128-383-0',15),
('BK014','Matematika X','Erlangga',2015,'Erlang','Pelajaran','978-979-254-726-10',80),
('BK015','Kesehjateraan Sosial','Rajagrafindo Persada',2015,'Isbandi Rukminto Adi','Karya Ilmiah','978-979-769-600-9',5),
('BK016','Teologi Seksual','LKiS',2004,'Geoffrey Parrinder','Ensiklopedia','979-338-106-x',10),
('BK017','Memuja Mantra','LKiS',2007,'Heru S.P. Saputra','Fiksi','978-602-118-605-3',12),
('BK018','Pengantar Membuat Robot','Gava Media',2006,'M. Ibnu Malik','Karya Ilmiah','978-979-346-982-X',12),
('BK019','Pengolahan Citra Digital : Konsep dan Teori','Andi Offset',2012,'Fajar Astuti Hermawati','Teori','978-979–293-119-8',12),
('BK020','Teknik Dasar Vidiografi','Andi Offset',2014,'Sarwo Nugroho','Teori','978-979-292-343-8',31),
('BK021','Personality Theories','Ar-Ruzz Media',2016,'George C. Boeree','Ensiklopedia','978-979-341-758-5',10),
('BK022','Ulumul Qur’an','Rajawali Pers',2014,'Muhammad Amin Suma','Ensiklopedia','978-979769534-7',10);

/*Table structure for table `peminjaman` */

DROP TABLE IF EXISTS `peminjaman`;

CREATE TABLE `peminjaman` (
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `nama_anggota` varchar(25) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_hrskembali` date NOT NULL,
  `jumlah` int(1) NOT NULL,
  `keterangan_pinjam` enum('Sudah kembali','Belum kembali') NOT NULL,
  PRIMARY KEY (`kode_pinjam`),
  KEY `id_anggota` (`id_anggota`),
  KEY `kode_buku` (`kode_buku`),
  CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`),
  CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `peminjaman` */

insert  into `peminjaman`(`kode_pinjam`,`id_anggota`,`nama_anggota`,`nis`,`kode_buku`,`judul`,`tgl_pinjam`,`tgl_hrskembali`,`jumlah`,`keterangan_pinjam`) values 
('163235','AGT001','Yasir','201754254','BK001','Matematika','2021-01-04','2021-01-11',1,'Sudah kembali'),
('172466','AGT010','Ernawati','111132070001150090','BK008','Pengolahan Citra Digital : Konsep dan Teori','2021-02-04','2021-02-11',1,'Belum kembali'),
('188214','AGT001','Yasir','201754254','BK001','Matematika','2020-12-28','2021-01-04',1,'Sudah kembali'),
('233521','AGT008','Michael San','202023654','BK005','Geografi IX','2021-02-04','2021-02-11',1,'Belum kembali'),
('328680','AGT032','Asep Maulana','111132070001150033','BK005','Geografi IX','2021-02-04','2021-02-11',1,'Belum kembali'),
('336206','AGT026','Shity Meyra Zahratul Muna','111132070001150034','BK018','Pengantar Membuat Robot','2021-01-29','2021-02-05',1,'Sudah kembali'),
('375258','AGT001','Yasir','111132070001150087','BK003','Biologi','2021-02-04','2021-02-11',1,'Belum kembali'),
('427643','AGT003','Wilona','20147514','BK004','Dilan','2021-01-04','2021-01-11',1,'Sudah kembali'),
('469792','AGT009','Yana Musdalifa','111132070001150022','BK001','Matematika','2021-01-29','2021-02-05',1,'Sudah kembali'),
('47638','AGT022','Desan Nurhasanah','111132070001150004','BK017','Memuja Mantra','2021-01-29','2021-02-05',1,'Sudah kembali'),
('525818','AGT017','Faizal Septiana','111132070001150053','BK013','Antropologi Al-Qur’an','2021-01-29','2021-02-05',1,'Sudah kembali'),
('582838','AGT015','Aditia Hidayat','111132070001150028','BK008','Pengolahan Citra Digital : Konsep dan Teori','2021-01-29','2021-02-05',1,'Sudah kembali'),
('601347','AGT018','Hidayatur Rohman','111132070001150056','BK009','Smart Creativepreneur','2021-01-29','2021-02-05',1,'Sudah kembali'),
('618747','AGT004','Aziz','202014568','BK001','Matematika','2021-01-27','2021-02-03',1,'Sudah kembali'),
('620577','AGT001','Yasir','201754254','BK001','Matematika','2021-01-18','2021-01-25',1,'Sudah kembali'),
('62838','AGT001','Yasir','201754254','BK003','Biologi','2021-02-03','2021-02-10',1,'Belum kembali'),
('722207','AGT002','Aldi','51422145','BK005','Geografi IX','2021-01-22','2021-01-29',1,'Sudah kembali'),
('72829','AGT019','Iyan Sofyan','111132070001150058','BK020','Teknik Dasar Vidiografi','2021-01-29','2021-02-05',1,'Sudah kembali'),
('734988','AGT001','Yasir','201754254','BK002','Sejarah','2020-12-28','2021-01-04',1,'Sudah kembali'),
('843581','AGT016','Ayudhia Zahira','111132070001150050','BK006','Akuntansi Pengantar 1','2021-01-29','2021-02-05',1,'Belum kembali'),
('844030','AGT001','Yasir','201754254','BK002','Sejarah','2021-01-05','2021-01-12',1,'Sudah kembali'),
('887777','AGT027','Angga Agustiana','111132070001150049','BK009','Smart Creativepreneur','2021-01-29','2021-02-05',1,'Sudah kembali'),
('920795','AGT030','Maemunah','111132070001150059','BK010','TEOLOGI KONSTITUSI','2021-01-29','2021-02-05',1,'Belum kembali'),
('931725','AGT020','Relsa Syindanis','111132070001150062','BK016','Teologi Seksual','2021-01-29','2021-02-05',1,'Sudah kembali'),
('944002','AGT001','Yasir','201754254','BK003','Biologi','2021-02-03','2021-02-10',1,'Belum kembali');

/*Table structure for table `pengembalian` */

DROP TABLE IF EXISTS `pengembalian`;

CREATE TABLE `pengembalian` (
  `kode_kembali` varchar(20) NOT NULL,
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(11) NOT NULL,
  `keterangan` enum('Telat','Tidak telat','Hilang') NOT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`kode_kembali`),
  KEY `kode_buku` (`kode_buku`),
  KEY `kode_pinjam` (`kode_pinjam`),
  KEY `id_anggota` (`id_anggota`),
  CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode_buku`),
  CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`kode_pinjam`) REFERENCES `peminjaman` (`kode_pinjam`),
  CONSTRAINT `pengembalian_ibfk_3` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pengembalian` */

insert  into `pengembalian`(`kode_kembali`,`kode_pinjam`,`id_anggota`,`kode_buku`,`tgl_kembali`,`denda`,`keterangan`,`jumlah`) values 
('167093','844030','AGT001','BK002','2021-01-20',4000,'Telat',1),
('18018','427643','AGT003','BK004','2021-01-20',4500,'Telat',1),
('190161','618747','AGT004','BK001','2021-02-04',200000,'Hilang',0),
('228467','72829','AGT019','BK020','2021-01-29',200000,'Hilang',0),
('344172','469792','AGT009','BK001','2021-01-29',0,'Tidak telat',1),
('376138','188214','AGT001','BK001','2020-12-28',0,'Tidak telat',1),
('448689','734988','AGT001','BK002','2020-12-28',200000,'Hilang',0),
('461397','887777','AGT027','BK009','2021-01-29',200000,'Hilang',0),
('555197','582838','AGT015','BK008','2021-01-29',200000,'Hilang',0),
('586517','47638','AGT022','BK017','2021-01-29',0,'Tidak telat',1),
('678584','525818','AGT017','BK013','2021-01-29',0,'Tidak telat',1),
('68725','601347','AGT018','BK009','2021-01-29',0,'Tidak telat',1),
('732525','163235','AGT001','BK001','2021-01-17',3000,'Telat',1),
('765462','722207','AGT002','BK005','2021-02-04',3000,'Telat',1),
('900744','620577','AGT001','BK001','2021-01-22',0,'Tidak telat',1),
('93186','336206','AGT026','BK018','2021-01-29',0,'Tidak telat',1),
('943801','931725','AGT020','BK016','2021-01-29',0,'Tidak telat',1);

/*Table structure for table `petugas` */

DROP TABLE IF EXISTS `petugas`;

CREATE TABLE `petugas` (
  `id_petugas` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk_petugas` varchar(15) NOT NULL,
  `telp_petugas` varchar(25) NOT NULL,
  `alamat_petugas` varchar(50) NOT NULL,
  PRIMARY KEY (`id_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `petugas` */

insert  into `petugas`(`id_petugas`,`nama`,`password`,`jk_petugas`,`telp_petugas`,`alamat_petugas`) values 
('PTGS01','Aldi Reza Pranata','123456789','Laki-laki','085654578954','Banjar'),
('PTGS02','Iim Nurmini','123456789','Perempuan','085654751456','CIamis'),
('PTGS03','Reza','123456789','Laki-laki','08532145657','Cimaragas');

/* Trigger structure for table `peminjaman` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `peminjaman_buku` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `peminjaman_buku` AFTER INSERT ON `peminjaman` FOR EACH ROW BEGIN
UPDATE buku SET jumlah = jumlah - new.jumlah
WHERE kode_buku = new.kode_buku;
END */$$


DELIMITER ;

/* Trigger structure for table `pengembalian` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `pengembalian_buku` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `pengembalian_buku` AFTER INSERT ON `pengembalian` FOR EACH ROW BEGIN
UPDATE buku SET jumlah = jumlah + new.jumlah
WHERE kode_buku = new.kode_buku;
END */$$


DELIMITER ;

/*Table structure for table `laporan_transaksi` */

DROP TABLE IF EXISTS `laporan_transaksi`;

/*!50001 DROP VIEW IF EXISTS `laporan_transaksi` */;
/*!50001 DROP TABLE IF EXISTS `laporan_transaksi` */;

/*!50001 CREATE TABLE  `laporan_transaksi`(
 `nama_anggota` varchar(25) ,
 `judul` varchar(50) ,
 `tgl_pinjam` date ,
 `tgl_kembali` date ,
 `keterangan` enum('Telat','Tidak telat','Hilang') ,
 `denda` int(11) 
)*/;

/*Table structure for table `lihat_transaksi` */

DROP TABLE IF EXISTS `lihat_transaksi`;

/*!50001 DROP VIEW IF EXISTS `lihat_transaksi` */;
/*!50001 DROP TABLE IF EXISTS `lihat_transaksi` */;

/*!50001 CREATE TABLE  `lihat_transaksi`(
 `id_anggota` varchar(20) ,
 `nama_anggota` varchar(25) ,
 `nis` varchar(20) ,
 `kode_pinjam` varchar(20) ,
 `judul` varchar(50) ,
 `tgl_pinjam` date ,
 `tgl_hrskembali` date ,
 `kode_kembali` varchar(20) ,
 `tgl_kembali` date ,
 `keterangan` enum('Telat','Tidak telat','Hilang') ,
 `denda` int(11) ,
 `keterangan_pinjam` enum('Sudah kembali','Belum kembali') 
)*/;

/*View structure for view laporan_transaksi */

/*!50001 DROP TABLE IF EXISTS `laporan_transaksi` */;
/*!50001 DROP VIEW IF EXISTS `laporan_transaksi` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_transaksi` AS select `peminjaman`.`nama_anggota` AS `nama_anggota`,`peminjaman`.`judul` AS `judul`,`peminjaman`.`tgl_pinjam` AS `tgl_pinjam`,`pengembalian`.`tgl_kembali` AS `tgl_kembali`,`pengembalian`.`keterangan` AS `keterangan`,`pengembalian`.`denda` AS `denda` from (`peminjaman` join `pengembalian` on(`peminjaman`.`kode_buku` = `pengembalian`.`kode_pinjam`)) */;

/*View structure for view lihat_transaksi */

/*!50001 DROP TABLE IF EXISTS `lihat_transaksi` */;
/*!50001 DROP VIEW IF EXISTS `lihat_transaksi` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lihat_transaksi` AS select `peminjaman`.`id_anggota` AS `id_anggota`,`peminjaman`.`nama_anggota` AS `nama_anggota`,`peminjaman`.`nis` AS `nis`,`peminjaman`.`kode_pinjam` AS `kode_pinjam`,`peminjaman`.`judul` AS `judul`,`peminjaman`.`tgl_pinjam` AS `tgl_pinjam`,`peminjaman`.`tgl_hrskembali` AS `tgl_hrskembali`,`pengembalian`.`kode_kembali` AS `kode_kembali`,`pengembalian`.`tgl_kembali` AS `tgl_kembali`,`pengembalian`.`keterangan` AS `keterangan`,`pengembalian`.`denda` AS `denda`,`peminjaman`.`keterangan_pinjam` AS `keterangan_pinjam` from (`peminjaman` left join `pengembalian` on(`peminjaman`.`kode_pinjam` = `pengembalian`.`kode_pinjam`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
