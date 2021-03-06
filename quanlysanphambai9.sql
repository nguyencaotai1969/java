USE [master]
GO
/****** Object:  Database [Quanlysanphambai9]    Script Date: 06/22/2020 21:03:34 ******/
CREATE DATABASE [Quanlysanphambai9] ON  PRIMARY 
( NAME = N'Quanlysanphambai9', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Quanlysanphambai9.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Quanlysanphambai9_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Quanlysanphambai9_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Quanlysanphambai9] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Quanlysanphambai9].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Quanlysanphambai9] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET ARITHABORT OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [Quanlysanphambai9] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Quanlysanphambai9] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Quanlysanphambai9] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET  DISABLE_BROKER
GO
ALTER DATABASE [Quanlysanphambai9] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Quanlysanphambai9] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Quanlysanphambai9] SET  READ_WRITE
GO
ALTER DATABASE [Quanlysanphambai9] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Quanlysanphambai9] SET  MULTI_USER
GO
ALTER DATABASE [Quanlysanphambai9] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Quanlysanphambai9] SET DB_CHAINING OFF
GO
USE [Quanlysanphambai9]
GO
/****** Object:  User [admin]    Script Date: 06/22/2020 21:03:34 ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[product]    Script Date: 06/22/2020 21:03:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productid] [nchar](10) NULL,
	[productname] [nchar](100) NULL,
	[uniprice] [float] NULL,
	[quantity] [int] NULL,
	[description] [text] NULL,
	[categoryid] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 06/22/2020 21:03:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](100) NULL,
	[description] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
