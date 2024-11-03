-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-11-2024 a las 02:35:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(100) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre_categoria`, `estado`) VALUES
(1, 'INDUSTRIA', 1),
(2, 'CONSTRUCCIÓN Y MADERA', 1),
(3, 'SELLANTES, FIJACIÓN Y TIRAFONDOS', 0),
(4, 'PINTURA Y COMPLEMENTOS', 0),
(5, 'PROTECCIÓN Y VESTUARIO', 0),
(6, 'EQUIPOS DE TRABAJO', 0),
(7, 'ELECTROPORTÁTILES', 0),
(8, 'JARDIN, AGRICULTURA Y TREFILADOS', 0),
(9, 'MATERIAL ELÉCTRICO Y ELECTRÓNICA', 0),
(10, 'CALEFACCIÓN Y VENTILACIÓN', 0),
(11, 'FONTANERIA Y BAÑO', 0),
(12, 'CERRAJERIA', 0),
(13, 'FERRETERIA DOMÉSTICA', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombres_apellidos` varchar(255) NOT NULL,
  `tipo_documento` varchar(3) DEFAULT NULL,
  `numero_documento` varchar(11) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombres_apellidos`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `email`, `estado`) VALUES
(1, 'Otto Gerald Araujo Villanueva', 'DNI', '72536050', 'Villa FAP San Gabino - Santiago de Surco', '920115109', 'ottogerald@hotmail.com', 0),
(4, 'Gabriel Sebastiane Hurtado Ospina', 'DNI', '72536037', 'Av. El Sol - Villa El Salvador', '902424944', 'gho@gmail.com', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `nro_comprobante` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `total` decimal(17,2) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compras`
--

CREATE TABLE `detalle_compras` (
  `id_detalle_compra` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` decimal(17,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` decimal(17,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `id_detalle_venta` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` decimal(17,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` decimal(17,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`id_detalle_venta`, `id_venta`, `id_producto`, `precio`, `cantidad`, `importe`) VALUES
(1, 4, 7, 20.00, 2, 40.00),
(2, 5, 7, 20.00, 5, 100.00),
(3, 5, 7, 20.00, 3, 60.00),
(4, 5, 7, 20.00, 8, 160.00),
(5, 6, 7, 20.00, 40, 800.00),
(6, 7, 7, 20.00, 3, 60.00),
(7, 8, 7, 20.00, 3, 60.00),
(8, 9, 7, 20.00, 3, 60.00),
(9, 10, 7, 20.00, 2, 40.00),
(10, 11, 7, 20.00, 2, 40.00),
(11, 12, 7, 20.00, 4, 80.00),
(12, 13, 7, 20.00, 1, 20.00),
(13, 14, 7, 20.00, 1, 20.00),
(14, 14, 1, 14.00, 2, 28.00),
(15, 15, 7, 20.00, 50, 1000.00),
(16, 16, 7, 20.00, 2, 40.00),
(17, 16, 1, 14.00, 3, 42.00),
(18, 17, 7, 20.00, 2, 40.00),
(19, 17, 1, 14.00, 1, 14.00),
(20, 18, 7, 20.00, 10, 200.00),
(21, 18, 1, 14.00, 10, 140.00),
(22, 19, 7, 20.00, 10, 200.00),
(23, 20, 1, 14.00, 4, 56.00),
(24, 20, 7, 20.00, 7, 140.00),
(25, 21, 7, 20.00, 10, 200.00),
(26, 22, 7, 20.00, 10, 200.00),
(27, 23, 28, 50.00, 1, 50.00),
(28, 24, 30, 90.00, 1, 90.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id_marca` int(11) NOT NULL,
  `nombre_marca` varchar(100) NOT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id_marca`, `nombre_marca`, `estado`) VALUES
(1, 'STANLEY', 0),
(2, 'BELLOTA', 0),
(3, 'BLACK AND DECKER', 0),
(4, 'MILWAUKEE', 0),
(5, 'MAKITA', 0),
(6, 'DEWALT', 0),
(7, 'BOSCH', 0),
(11, 'AAAAAA', 0),
(12, 'AAAAAAA', 0),
(13, 'EEEEEE', 0),
(14, 'YYYYY', 0),
(15, 'OOOO', 0),
(16, 'WWWWWW', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `precio_compra` decimal(17,2) NOT NULL,
  `precio_venta` decimal(17,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `fecha_ingreso` timestamp NULL DEFAULT current_timestamp(),
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `id_categoria`, `id_marca`, `precio_compra`, `precio_venta`, `stock`, `fecha_ingreso`, `estado`) VALUES
(1, 'Taladro Atornillador Inalámbrico 3/8\" 12V', 7, 4, 12.00, 14.00, 10, '2023-11-27 00:00:00', 0),
(7, 'Taladro Percutor Eléctrico 1/2\" 800W', 5, 5, 15.00, 20.00, 20, '2023-11-29 00:00:00', 0),
(8, 'AAA', 4, 4, 13.00, 15.00, 0, '2023-12-01 00:00:00', 0),
(9, 'BBB', 6, 5, 15.00, 28.00, 0, '2023-12-01 00:00:00', 0),
(10, 'WWWW', 5, 13, 13.00, 16.00, -8, '2023-12-01 00:00:00', 1),
(15, 'martillo ', 1, 2, 50.00, 60.00, 10, '2023-12-02 15:10:19', 1),
(16, 'Tornillos para Madera', 1, 3, 60.00, 80.00, 20, '2023-12-02 15:10:19', 0),
(17, 'Sierra Circular', 2, 4, 20.00, 30.00, 5, '2023-12-02 15:10:19', 0),
(18, 'Llave Ajustable', 2, 2, 10.00, 40.00, 6, '2023-12-02 15:10:19', 0),
(19, 'Clavos Galvanizados', 1, 1, 60.00, 70.00, 10, '2023-12-02 15:10:19', 0),
(20, 'Destornillador Phillips', 3, 2, 50.00, 60.00, 40, '2023-12-02 15:10:19', 0),
(21, 'Cinta Métrica', 5, 3, 10.00, 10.50, 20, '2023-12-02 15:10:19', 0),
(22, 'Lijadora Eléctrica', 9, 11, 200.00, 220.00, 10, '2023-12-02 15:10:19', 0),
(23, 'Taladro Inalámbrico', 4, 4, 500.00, 600.00, 10, '2023-12-02 15:10:19', 0),
(24, 'Cadenas para Motosierra', 8, 4, 250.00, 300.00, 20, '2023-12-02 15:10:19', 0),
(25, 'Grapas para Pistola de Grapas', 7, 2, 30.00, 40.00, 9, '2023-12-02 15:10:19', 0),
(26, 'Grapas para Pistola de Grapas', 3, 5, 50.00, 60.00, 8, '2023-12-02 15:10:19', 0),
(27, 'Brocas para Hormigón', 2, 6, 120.00, 200.00, 30, '2023-12-02 15:10:19', 0),
(28, 'Sierra de Mano', 8, 1, 40.00, 50.00, 19, '2023-12-02 15:10:19', 0),
(29, 'Nivel de Burbuja', 7, 4, 30.00, 40.00, 15, '2023-12-02 15:10:19', 0),
(30, 'Candado de Alta Seguridad', 5, 2, 80.00, 90.00, 9, '2023-12-02 15:10:19', 0),
(31, 'Pintura Antioxidante', 6, 5, 90.00, 100.00, 40, '2023-12-02 15:10:19', 0),
(32, 'Pala de Jardín', 8, 2, 300.00, 400.00, 10, '2023-12-02 15:10:19', 0),
(33, 'Escalera de Aluminio', 9, 7, 1200.00, 1300.00, 2, '2023-12-02 15:10:19', 0),
(34, 'Cerradura de Puerta', 8, 7, 50.00, 60.00, 3, '2023-12-02 15:10:20', 0),
(35, 'Caja de Herramientas Metálica', 1, 2, 3000.00, 4000.00, 1, '2023-12-02 15:10:20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `razon_social` varchar(100) NOT NULL,
  `ruc` varchar(20) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedor`, `razon_social`, `ruc`, `direccion`, `telefono`, `email`, `estado`) VALUES
(1, 'ZZZ', '111', '321', '321', 'ZZZ', 1),
(3, 'Asesoria Inmobiliaria', '20123456789', 'Jr. Ayacucho 123, Miraflores, Lima', '987654321', 'asesoriainmobiliaria@gmail.com', 0),
(4, 'A&M tecnicos Ingenieros SAC', '17890123456', 'Av. Huascarán 456, San Isidro, Lima', '912345678', 'amtecnicosingenieros@tecnicosA&M.com', 1),
(5, 'Om Decoracion Comercial', '22345678901', 'Calle Tacna 789, Barranco, Lima', '998877665', 'omdecoracioncomercial@outlook.com', 1),
(6, 'Asesores y Tecnicos Gastronomicos atg eirl', '15678901234', 'Av. Amazonas 234, Cusco', '976543210', 'atggastronomicos@gmail.com', 1),
(7, 'CASITEX PERU', '26789012345', 'Jr. Puno 567, Arequipa', '961234567', 'casitexperu@casitex.com', 1),
(8, 'Contruccion Creativa', '31234567890', 'Callejón Huancavelica 890, Trujillo', '994321098', 'construccioncreativa@gmail.com', 1),
(9, 'SanMarlu EIRL', '34567890123', 'Av. Junín 123, Chiclayo', '950876543', 'sanmarlu@outlook.com', 1),
(10, 'Corporacion Tecnica Navarro Hnos SAC', '49012345678', 'Jr. Ucayali 456, Iquitos', '967890123', 'corporaciontecnica@gmail.com', 0),
(11, 'Acd Servicios Generales S.A.C', '43456789012', 'Calle Huallaga 789, Huancayo', '955432109', 'acdservicios@hotmail.com', 1),
(12, 'Servicios Generales Urquizo E.I.R.L', '52345678901', 'Av. Cajamarca 234, Piura', '978901234', 'urquizoservicios@urq.com', 1),
(13, 'Ingenieria Global y Empresarial S.A.C', '56789012345', 'Jr. Abancay 567, Chimbote', '983210987', 'ingenieriaglobal@global.com', 1),
(14, 'Servicios Industriales Olaya SAC', '61234567890', 'Calle Ancash 890, Tacna', '966543210', 'serviciosolaya@gmail.com', 1),
(15, 'Ciudaris Consultores Inmobiliarios', '64567890123', 'Av. Apurímac 123, Ica', '982109876', 'ciudarisconsultores@ciudaris.com', 0),
(16, 'Bussiness E&C EIRL', '79012345678', 'Jr. Loreto 456, Pucallpa', '973210987', 'businessenc@enc.com', 1),
(17, 'Desinfecciones y Fumigaciones E&M ', '73456789012', 'Calle Madre de Dios 789, Huaraz', '988765432', 'emdesinfegm@EM.com', 1),
(18, 'Empresa de Construccion y Consultoria Steven EIRL', '82345678901', 'Av. Tumbes 234, Tarapoto', '972109876', 'stevenconstruccion@outlook.com', 0),
(19, 'Eco LARENAS SAC', '86789012345', 'Jr. Moquegua 567, Juliaca', '979876543', 'ecolarenas@ecolarenas.com', 1),
(20, 'Servicios Generales CEYCOR EIRL', '91234567890', 'Av. Lambayeque 890, Chincha', '969876543', 'ceycorservicios@ceycor.com', 0),
(21, 'Grapco SAC', '94567890123', 'Calle Pasco 123, Tumbes', '987654321', 'grapsaco@gmail.com', 1),
(22, 'JH Arquitectura y Construccion SAC', '9012345678', 'Jr. La Libertad 456, Pisco', '971234567', 'jharqyconstruccion@JH.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `rol`) VALUES
(1, 'Administrador'),
(2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `tipo_documento` varchar(10) NOT NULL,
  `nro_documento` varchar(20) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fecha_ingreso` timestamp NULL DEFAULT current_timestamp(),
  `ultimo_acceso` datetime DEFAULT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `id_rol`, `nombres`, `apellidos`, `tipo_documento`, `nro_documento`, `telefono`, `email`, `username`, `password`, `fecha_ingreso`, `ultimo_acceso`, `estado`) VALUES
(1, 1, 'RAUL', 'PAUCAR', 'DNI', '45164578', '902424944', 'raul.ferret@gmail.com', 'RAUL PAUCAR', '123456', '2024-11-03 00:00:00', NULL, 0),
(3, 1, 'RENZO', 'REYES', 'DNI', '54125478', '985412546', 'renzo.ferret@gmail.com', 'renzo', '123456', '2024-11-03 00:00:00', NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `nro_comprobante` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `total` decimal(17,2) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `id_usuario`, `id_cliente`, `tipo_comprobante`, `nro_comprobante`, `fecha`, `hora`, `total`, `estado`) VALUES
(4, 1, 4, 'Boleta', '0000', '2023-11-30', '07,08,03', 40.00, 0),
(5, 1, 1, 'Boleta', '0000', '2023-11-30', '07,09,23', 320.00, 0),
(6, 1, 4, 'Boleta', '0000', '2023-12-01', '01,10,51', 800.00, 0),
(7, 1, 4, 'Boleta', '0000', '2023-12-01', '01,53,11', 60.00, 0),
(8, 1, 1, 'Boleta', '0000', '2023-12-01', '01,55,08', 60.00, 0),
(9, 1, 4, 'Boleta', '0000', '2023-12-01', '02,08,50', 60.00, 0),
(10, 1, 1, 'Boleta', '0000', '2023-12-01', '02,10,37', 40.00, 0),
(11, 1, 4, 'Boleta', '0000', '2023-12-01', '02,14,02', 40.00, 0),
(12, 1, 4, 'Boleta', '0000', '2023-12-01', '02,42,03', 80.00, 0),
(13, 1, 1, 'Boleta', '0000', '2023-12-01', '02,44,56', 20.00, 0),
(14, 1, 4, 'Boleta', '0000', '2023-12-01', '02,50,43', 48.00, 0),
(15, 1, 4, 'Boleta', '0000', '2023-12-01', '06,08,20', 1000.00, 0),
(16, 1, 4, 'Boleta', '0000', '2023-12-01', '10,34,36', 82.00, 0),
(17, 1, 4, 'Boleta', '0000', '2023-12-01', '11,12,03', 54.00, 0),
(18, 1, 4, 'Boleta', '0000', '2023-12-02', '02,51,06', 340.00, 0),
(19, 1, 4, 'Boleta', '0000', '2023-12-02', '02,59,55', 200.00, 0),
(20, 1, 1, 'Boleta', '0000', '2023-12-02', '03,02,31', 196.00, 0),
(21, 1, 4, 'Boleta', '0000', '2023-12-02', '04: 35: 14', 200.00, 0),
(22, 1, 4, 'Boleta', '0001', '2023-12-02', '04: 54: 22', 200.00, 0),
(23, 1, 4, 'Boleta', '0002', '2023-12-02', '10:27:47', 50.00, 0),
(24, 1, 1, 'Boleta', '0003', '2023-12-02', '10:30:28', 90.00, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `fk_id_usuario_compras` (`id_usuario`),
  ADD KEY `fk_id_proveedor_compras` (`id_proveedor`);

--
-- Indices de la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD PRIMARY KEY (`id_detalle_compra`),
  ADD KEY `fk_id_compra_detalle_compra` (`id_compra`),
  ADD KEY `fk_id_producto_detalle_compra` (`id_producto`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`id_detalle_venta`),
  ADD KEY `fk_id_venta` (`id_venta`),
  ADD KEY `fk_id_producto` (`id_producto`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `fk_id_categoria` (`id_categoria`),
  ADD KEY `fk_id_marca` (`id_marca`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_id_rol` (`id_rol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `fk_id_usuario` (`id_usuario`),
  ADD KEY `fk_id_cliente` (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `fk_id_proveedor_compras` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  ADD CONSTRAINT `fk_id_usuario_compras` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD CONSTRAINT `fk_id_compra_detalle_compra` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  ADD CONSTRAINT `fk_id_producto_detalle_compra` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `fk_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_id_venta` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`),
  ADD CONSTRAINT `fk_id_marca` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id_marca`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_id_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `fk_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
