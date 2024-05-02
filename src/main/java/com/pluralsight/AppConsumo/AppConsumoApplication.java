package com.pluralsight.AppConsumo;

import com.pluralsight.AppConsumo.model.Prestaciones;
import com.pluralsight.AppConsumo.model.Vehiculo;

import com.pluralsight.AppConsumo.model.VehiculoPrestacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class AppConsumoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppConsumoApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

		//URL de endpoint
		String urlVehiculos = "http://localhost:8080/vehiculos";
		String urlPrestaciones = "http://localhost:8080/prestaciones";

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------- Vehiculos -------");
		//Alta de vehiculo
		//Vehiculo
		System.out.println("------- Alta de vehiculos -------");
		Vehiculo vehiculo = new Vehiculo( "WED321",
										  "123213554",
										  "3546468",
										  "Toyota",
										  "Gris",
										  "2024",
										"Alta");

		Vehiculo vehiculo2 = new Vehiculo( "HYT728",
				"46498484",
				"789498",
				"Nissan",
				"Blanco",
				"2024",
				"Alta");

		Vehiculo vehiculo3 = new Vehiculo( "NBV963",
				"14147175417",
				"3785357537",
				"Mazda",
				"Negro",
				"2024",
				"Alta");

		//Se realiza la peticion
		Vehiculo responseAltaVehiculo1 = restTemplate.postForObject(urlVehiculos, vehiculo, Vehiculo.class);
		System.out.println("Vehiculo 1 registrado: " + responseAltaVehiculo1);
		//Se realiza la peticion
		Vehiculo responseAltaVehiculo2 = restTemplate.postForObject(urlVehiculos, vehiculo2, Vehiculo.class);
		System.out.println("Vehiculo 2 registrado: " + responseAltaVehiculo2);
		//Se realiza la peticion
		Vehiculo responseAltaVehiculo3 = restTemplate.postForObject(urlVehiculos, vehiculo3, Vehiculo.class);
		System.out.println("Vehiculo 3 registrado: " + responseAltaVehiculo3);

		//Actualizacion de informacion del vehiculo
		long idUpdate = 3;
		Vehiculo updateVehiculo = new Vehiculo( "NBV963",
												"46498484",
												"789498",
												"Mazda",
												"Gris",
												"2024",
												"Alta");
		System.out.println("------- Actualizacion de vehiculos -------");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<Vehiculo> requestBody = new HttpEntity<>(updateVehiculo, headers);

		//Se realiza la peticion
		ResponseEntity<Vehiculo> response = restTemplate.exchange(urlVehiculos + "/{id}", HttpMethod.PUT, requestBody, Vehiculo.class, idUpdate);

		Vehiculo vehiculoActualizadoRespuesta = response.getBody();

		System.out.println("Vehículo actualizado: " + vehiculoActualizadoRespuesta);


		//Baja de vehiculos
		System.out.println("------- Baja de vehiculos -------");
		long idDelete = 3;
		//Se realiza la peticion
		ResponseEntity<String> responseDeleteVehiculo = restTemplate.exchange(urlVehiculos + "/{id}", HttpMethod.DELETE, null, String.class, idDelete);

		String mensajeRespuesta = responseDeleteVehiculo.getBody();

		System.out.println("id= " + idDelete + ", " + mensajeRespuesta);

		//Consultas de vehiculos
		System.out.println("------- Consulta de vehiculos -------");
		ResponseEntity<List<Vehiculo>> responseConsultaVehiculos = restTemplate.exchange(
				urlVehiculos,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Vehiculo>>() {}
		);

		List<Vehiculo> listaVehiculos = responseConsultaVehiculos.getBody();

		System.out.println(listaVehiculos);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------- Prestaciones -------");
		//Alta de prestaciones
		System.out.println("------- Alta de prestaciones -------");
		VehiculoPrestacion vehiculoPrestacion1 = new VehiculoPrestacion( 1,
																		"WED321",
																		"123213554",
																		"3546468",
																		"Toyota",
																		"Gris",
																		"2024",
																		"Alta");

		VehiculoPrestacion vehiculoPrestacion2 = new VehiculoPrestacion( 2,
																		"HYT728",
																		"46498484",
																		"789498",
																		"Nissan",
																		"Blanco",
																		"2024",
																		"Alta");
		VehiculoPrestacion vehiculoPrestacion3 = new VehiculoPrestacion( 2,
																		"HYT728",
																		"46498484",
																		"789498",
																		"Nissan",
																		"Blanco",
																		"2024",
																		"Alta");

		VehiculoPrestacion vehiculoPrestacion4 = new VehiculoPrestacion( 1,
																		"NBV963",
																		"123213554",
																		"3546468",
																		"Toyota",
																		"Gris",
																		"2024",
																		"Alta");

		Prestaciones prestacion1 = new Prestaciones("2024-04-25",
													"Prestacion de toyota gris",
													"Se dio de alta el uso de automovil toyota gris",
													"1200.80",
													"Alta",
													vehiculoPrestacion1);

		Prestaciones prestacion2 = new Prestaciones("2024-04-24",
				"Prestacion de Nissan blanco",
				"Se dio de alta una prestacion para viaje con nissan versa blanco",
				"1456.32",
				"Alta",
				vehiculoPrestacion2);

		Prestaciones prestacion3 = new Prestaciones("2024-04-24",
				"Prestacion de Nissan blanco",
				"Se dio de alta la prestacion para uso diario en ciudad, el auto fue nissan versa blanco",
				"1354.45",
				"Alta",
				vehiculoPrestacion3);

		Prestaciones prestacion4 = new Prestaciones("2024-04-23",
				"Prestacion de toyota gris",
				"Se dio de alta el uso de automovil toyota gris para viaje laboral",
				"1630.86",
				"Alta",
				vehiculoPrestacion4);

		//Se realiza la peticion
		Prestaciones responseAltaPrestacion1 = restTemplate.postForObject(urlPrestaciones, prestacion1, Prestaciones.class);
		System.out.println("Prestacion 1 registrada: " + responseAltaPrestacion1);
		//Se realiza la peticion
		Prestaciones responseAltaPrestacion2 = restTemplate.postForObject(urlPrestaciones, prestacion2, Prestaciones.class);
		System.out.println("Prestacion 2 registrado: " + responseAltaPrestacion2);
		//Se realiza la peticion
		Prestaciones responseAltaPrestacion3 = restTemplate.postForObject(urlPrestaciones, prestacion3, Prestaciones.class);
		System.out.println("Prestacion 3 registrado: " + responseAltaPrestacion3);
		//Se realiza la peticion
		Prestaciones responseAltaPrestacion4 = restTemplate.postForObject(urlPrestaciones, prestacion4, Prestaciones.class);
		System.out.println("Prestacion 4 registrado: " + responseAltaPrestacion4);

		//Actualizacion de informacion del vehiculo
		long idUpdatePrestacion = 4;
		VehiculoPrestacion updateVehiculoPrestacion = new VehiculoPrestacion( 2,
																			"HYT728",
																			"46498484",
																			"789498",
																			"Nissan",
																			"Blanco",
																			"2024",
																			"Alta");
		Prestaciones prestacionVP = new Prestaciones("2024-04-23",
				"Prestacion de toyota gris",
				"Se dio de alta el uso de automovil toyota gris, para viaje familiar",
				"1560.80",
				"Alta",
				updateVehiculoPrestacion);

		System.out.println("------- Actualizacion de vehiculos -------");

		HttpHeaders headersVP = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<Prestaciones> requestBodyVP = new HttpEntity<>(prestacionVP, headersVP);

		//Se realiza la peticion
		ResponseEntity<Prestaciones> responseVP = restTemplate.exchange(urlPrestaciones + "/{id}", HttpMethod.PUT, requestBodyVP, Prestaciones.class, idUpdatePrestacion);

		Prestaciones prestacionVehiculoUpdate = responseVP.getBody();

		System.out.println("Vehículo actualizado: " + prestacionVehiculoUpdate);

		//Baja de vehiculos
		System.out.println("------- Baja de prestaciones -------");
		long idDeleteVP = 4;
		//Se realiza la peticion
		ResponseEntity<String> responseDeleteVP = restTemplate.exchange(urlPrestaciones + "/{id}", HttpMethod.DELETE, null, String.class, idDeleteVP);

		String mensajeRespuestaVP = responseDeleteVP.getBody();

		System.out.println("id= " + idDeleteVP + ", " + mensajeRespuestaVP);

		//Consultas de prestaciones
		System.out.println("------- Consulta de prestaciones -------");
		ResponseEntity<List<Prestaciones>> responseConsultaPrestaciones = restTemplate.exchange(
				urlPrestaciones,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Prestaciones>>() {}
		);

		List<Prestaciones> listaPrestacionVehiculos = responseConsultaPrestaciones.getBody();

		System.out.println(listaPrestacionVehiculos);


		//Consultas personalizadas
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------- Consultas -------");
		//Consulta para patente identificatoria
		System.out.println("------- Consulta apartir de una patente identificatoria -------");
		String patenteIdentificatoria = "HYT728";
		ResponseEntity<List<Prestaciones>> responseConsultaPatenteIdentificatoria = restTemplate.exchange(
				urlPrestaciones + "/vehiculoInfoPrestacion/{patenteIdentificadora}",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Prestaciones>>() {},
				patenteIdentificatoria
		);

		List<Prestaciones> ListaRegistrosPrestacionesPI = responseConsultaPatenteIdentificatoria.getBody();

		System.out.println("Patente buscada: " + patenteIdentificatoria);
		System.out.println(ListaRegistrosPrestacionesPI);

		//Consulta apartir por fecha
		System.out.println("------- Consulta apartir de una fecha -------");
		String fechaPrestacion = "2024-04-24";
		ResponseEntity<List<Prestaciones>> responseConsultaFechaPrestacion = restTemplate.exchange(
				urlPrestaciones + "/fechaAtendidos/{fecha}",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Prestaciones>>() {},
				fechaPrestacion
		);

		List<Prestaciones> ListaRegistrosPorFecha = responseConsultaFechaPrestacion.getBody();
		System.out.println("Fecha buscada: " + fechaPrestacion);
		System.out.println(ListaRegistrosPorFecha);


	}

}
