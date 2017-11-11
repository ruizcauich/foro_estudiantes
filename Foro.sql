-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 11, 2017 at 07:19 PM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Foro`
--

-- --------------------------------------------------------

--
-- Table structure for table `Comentarios`
--

CREATE TABLE `Comentarios` (
  `id` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `contenido` varchar(400) NOT NULL,
  `publicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Table structure for table `Comentarios-Comentarios`
--

CREATE TABLE `Comentarios-Comentarios` (
  `id` int(11) NOT NULL,
  `comentarioPrincipal` int(11) NOT NULL,
  `comentarioSeundario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Publicaciones`
--

CREATE TABLE `Publicaciones` (
  `usuario` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `contenido` varchar(1000) DEFAULT NULL,
  `topico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `Usuarios`
--

CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `institucion` varchar(150) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  `email` varchar(100) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  `es_moderador` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Usuarios`
--

INSERT INTO `Usuarios` (`id`, `nombre`, `apellidos`, `institucion`, `nickname`, `contrasena`, `email`, `avatar`, `es_moderador`) VALUES
(1, 'augusto neftali', 'Ruiz', 'itche', 'august', 'august', 'august', NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Comentarios`
--
ALTER TABLE `Comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `publicacion` (`publicacion`) USING BTREE;

--
-- Indexes for table `Comentarios-Comentarios`
--
ALTER TABLE `Comentarios-Comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comentarioPrincipal` (`comentarioPrincipal`),
  ADD KEY `comentarioSecundario` (`comentarioSeundario`);

--
-- Indexes for table `Publicaciones`
--
ALTER TABLE `Publicaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario` (`usuario`);

--
-- Indexes for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Comentarios`
--
ALTER TABLE `Comentarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Comentarios-Comentarios`
--
ALTER TABLE `Comentarios-Comentarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Publicaciones`
--
ALTER TABLE `Publicaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Comentarios`
--
ALTER TABLE `Comentarios`
  ADD CONSTRAINT `Comentarios_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `Usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Comentarios_ibfk_2` FOREIGN KEY (`publicacion`) REFERENCES `Publicaciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Comentarios-Comentarios`
--
ALTER TABLE `Comentarios-Comentarios`
  ADD CONSTRAINT `Comentarios-Comentarios_ibfk_1` FOREIGN KEY (`comentarioPrincipal`) REFERENCES `Comentarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Comentarios-Comentarios_ibfk_2` FOREIGN KEY (`comentarioSeundario`) REFERENCES `Comentarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Publicaciones`
--
ALTER TABLE `Publicaciones`
  ADD CONSTRAINT `Publicaciones_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `Usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
