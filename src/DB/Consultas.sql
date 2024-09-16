/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  2dam
 * Created: 16-sep-2024
 */

CREATE DATABASE IF NOT EXISTS Reto0DIN;
USE Reto0DIN;
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE IF NOT EXISTS USUARIO(
ID INT PRIMARY KEY,
NOMBRE VARCHAR(50),
EMAIL VARCHAR(50),
TELEFONO INT);

INSERT INTO USUARIO VALUES(1,"Manolo","manolo@email.es",123456789);


