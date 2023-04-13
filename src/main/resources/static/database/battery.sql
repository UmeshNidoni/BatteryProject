-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2021 at 08:26 AM
-- Server version: 5.7.22-log
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `battery`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_email` varchar(225) NOT NULL,
  `admin_password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_email`, `admin_password`) VALUES
(1, 'admin@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `battery`
--

CREATE TABLE `battery` (
  `battery_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `serial_no` varchar(225) NOT NULL,
  `supplier_name` varchar(225) NOT NULL,
  `invoice_no` varchar(225) NOT NULL,
  `status` varchar(225) NOT NULL,
  `model_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `battery`
--

INSERT INTO `battery` (`battery_id`, `date`, `serial_no`, `supplier_name`, `invoice_no`, `status`, `model_id`) VALUES
(1, '2021-08-12', 'b1', 'Suman Byakod', '123', 'active', 1),
(2, '2021-08-12', 'b2', 'Suman Byakod', '123', 'inactive', 1),
(3, '2021-08-12', 'b3', 'Suman Byakod', '123', 'inactive', 0),
(4, '2021-08-12', 'b4', 'Suman Byakod', '123', 'inactive', 0),
(5, '2021-08-12', 'b5', 'Suman Byakod', '123', 'inactive', 0),
(6, '2021-08-12', 'b6', 'Suman Byakod', '123', 'active', 0),
(7, '2021-08-26', '11111AAAAA', 'Kedar', '123456789', 'inactive', 1),
(8, '2021-08-26', '22222BBBBB', 'Kedar', '123456789', 'inactive', 1),
(9, '2021-08-28', '123456789', 'ABCD', '12345', 'active', 2),
(10, '2021-08-28', '789456321', 'ABCD', '12345', 'active', 2);

-- --------------------------------------------------------

--
-- Table structure for table `battery_model`
--

CREATE TABLE `battery_model` (
  `model_id` int(50) NOT NULL,
  `model_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `battery_model`
--

INSERT INTO `battery_model` (`model_id`, `model_name`) VALUES
(1, 'ZXC10AAAABBBCCCDDD'),
(2, 'XYZ12345');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `customer_id` varchar(50) NOT NULL,
  `total_amount` varchar(50) NOT NULL,
  `previous_balance_collected` varchar(50) NOT NULL,
  `payment_collected` varchar(50) NOT NULL,
  `balance_payment` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `date`, `customer_id`, `total_amount`, `previous_balance_collected`, `payment_collected`, `balance_payment`) VALUES
(1, '2021-08-12', '8494976350', '20000', '0', '10000', '10000'),
(2, '2021-08-13', '7483094563', '30000', '0', '25000', '5000'),
(3, '2021-08-26', '7483094563', '15000', '5000', '10000', '10000');

-- --------------------------------------------------------

--
-- Table structure for table `sales_battery_serial`
--

CREATE TABLE `sales_battery_serial` (
  `sales_battery_serial_id` int(11) NOT NULL,
  `sale_date` date NOT NULL,
  `customer_id` varchar(225) NOT NULL,
  `serial_no` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_battery_serial`
--

INSERT INTO `sales_battery_serial` (`sales_battery_serial_id`, `sale_date`, `customer_id`, `serial_no`) VALUES
(1, '2021-08-12', '8494976350', 'b5'),
(2, '2021-08-12', '8494976350', 'b2'),
(3, '2021-08-13', '7483094563', 'b3'),
(4, '2021-08-13', '7483094563', 'b4'),
(5, '2021-08-26', '7483094563', '11111AAAAA'),
(6, '2021-08-26', '7483094563', '22222BBBBB');

-- --------------------------------------------------------

--
-- Table structure for table `sub_dealer`
--

CREATE TABLE `sub_dealer` (
  `sub_dealer_id` int(11) NOT NULL,
  `sub_dealer_name` varchar(225) NOT NULL,
  `contact_no` varchar(225) NOT NULL,
  `address` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_dealer`
--

INSERT INTO `sub_dealer` (`sub_dealer_id`, `sub_dealer_name`, `contact_no`, `address`) VALUES
(1, 'kumar Byakod', '8494976350', 'Huvin Hipparagi'),
(2, 'Ashish Kulkarni', '7483094563', 'Bagalkot');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `battery`
--
ALTER TABLE `battery`
  ADD PRIMARY KEY (`battery_id`);

--
-- Indexes for table `battery_model`
--
ALTER TABLE `battery_model`
  ADD PRIMARY KEY (`model_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`);

--
-- Indexes for table `sales_battery_serial`
--
ALTER TABLE `sales_battery_serial`
  ADD PRIMARY KEY (`sales_battery_serial_id`);

--
-- Indexes for table `sub_dealer`
--
ALTER TABLE `sub_dealer`
  ADD PRIMARY KEY (`sub_dealer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `battery`
--
ALTER TABLE `battery`
  MODIFY `battery_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `battery_model`
--
ALTER TABLE `battery_model`
  MODIFY `model_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sales_battery_serial`
--
ALTER TABLE `sales_battery_serial`
  MODIFY `sales_battery_serial_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `sub_dealer`
--
ALTER TABLE `sub_dealer`
  MODIFY `sub_dealer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
