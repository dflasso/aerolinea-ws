INSERT INTO CLIENTE (
ID_CLIENTE, CORREO_CLIENTE ,APELLIDO_CLIENTE ,NOMBRE_CLIENTE ,NUM_IDENTIFICATION_CLIENTE , telefono_cliente ) 
values 
(2, 'dany@gmail.com' , 'Caiza' ,'Oswaldo', '1708102718' , '0988334477'),
(3, 'stalin@hotmail.com' , 'Llumiquinga' ,'Miriam Mónica', '1708051311' , '0988334477'),
(1, 'xavier@hotmail.com' , 'Vaca' ,'Xavier', '1723401715' , '0988334477'),
(4, 'paul@gmail.com' , 'Alcivar' ,'Paul', '1708102718' , '0988334477'),
(5, 'oscar@hotmail.com' , 'Sandoval' ,'Oscar', '1708051311' , '0988334477'),
(6, 'juan@hotmail.com' , 'Mendoza' ,'Juan', '1723401715' , '0988334477');



INSERT INTO Agencia (
id_agencia, agencia_RUC ,agencia_razon_social  ) 
values 
(1, '0990633436001' , 'Viajecitos S.A.' ),
(2, '0990017514001' , 'Agencia X S.A.');


INSERT INTO Ubicacion_Geo (
id_ubicacion, codigo_ubicacion ,nombre_ubicacion, pais_ubicacion, tipo_ubicacion, id_territorio_perteneciente  ) 
values 
(1, '0150' , 'CUENCA', 'ECUADOR', 'TG004', null ),
(2, '0250' , 'GUARANDA', 'ECUADOR', 'TG004', null ),
(3, '0350' , 'AZOGUES', 'ECUADOR', 'TG004', null ),
(4, '0350' , 'TULCAN', 'ECUADOR', 'TG004', null ),
(5, '0350' , 'LATACUNGA', 'ECUADOR', 'TG004', null ),
(6, '0450' , 'RIOBAMBA', 'ECUADOR', 'TG004', null ),
(7, '0550' , 'MACHALA', 'ECUADOR', 'TG004', null ),
(8, '0650' , 'ESMERALDAS', 'ECUADOR', 'TG004', null ),
(9, '1750' , 'QUITO', 'ECUADOR', 'TG004', null );

INSERT INTO Vuelos (
id_vuelo, fecha_hora_salida ,ticket_costo, ticket_disponibles, ticket_total, id_ciudad_origen, id_ciudad_destino  ) 
values 
(1, '2021-08-06' , 88.99, 50, 50, 1, 2 ),
(2, '2021-08-07' , 70.50, 60, 60, 3, 2 ),
(3, '2021-08-08' , 120.99, 70, 70, 9, 2 ),
(4, '2021-08-09' , 100.00, 80, 80, 9, 3 ),
(5, '2021-08-10' , 55.60, 90, 90, 6, 9 ),
(6, '2021-08-11' , 150.60, 50, 50, 5, 7 ),
(7, '2021-08-06' , 99.99, 55, 55, 6, 4 ),
(8, '2021-08-06' , 178.33, 80, 80, 3, 8 ),
(9, '2021-08-06' , 200.00, 90, 90, 7, 9 ),
(10, '2021-08-06' , 70, 50, 50, 1, 2 ),
(11, '2021-08-06' , 85.99, 50, 50, 1, 2 ),
(12, '2021-08-06' , 80.99, 50, 50, 1, 2 ),
(13, '2021-08-06' , 79.99, 50, 50, 1, 2 );



