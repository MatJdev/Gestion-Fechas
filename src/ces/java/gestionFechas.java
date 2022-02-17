package ces.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class gestionFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate hoy = LocalDate.now();
		System.out.println("La fecha de hoy es:" + hoy);

		// Obtenci�n de partes por separado.

		int year = hoy.getYear();
		int month = hoy.getMonthValue();
		int day = hoy.getDayOfMonth();
		int dayYear = hoy.getDayOfYear();
		DayOfWeek dayWeek = hoy.getDayOfWeek();

		System.out.printf(" --> Hoy es el dia %d del mes %d y es el d�a %d del a�o %d, y es %d en la semana", day,
				month, dayYear, year, dayWeek.getValue());

		// Para obtener un objeto fecha a partir de una fecha concreta:

		LocalDate diaNacimientoJuan = LocalDate.of(1980, 1, 23);
		System.out.println("La fecha del nacimiento de Juan es:" + diaNacimientoJuan);

		// Fechas iguales

		if (hoy.isEqual(diaNacimientoJuan)) {
			System.out.printf(" Las fechas de hoy %s y %s son iguales", hoy, diaNacimientoJuan);
		} else {
			System.out.println("Son dos fechas diferentes");
		}

		// Eventos recurrentes en un a�o
		// MonthDay almacena una fecha pero sin a�o

		MonthDay fechaCumpleaños = MonthDay.of(hoy.getMonth(), hoy.getDayOfMonth());
		MonthDay fechaHoy = MonthDay.from(LocalDate.now());
		if (fechaHoy.equals(fechaCumpleaños)) {
			System.out.println(" FELICIDADES -> Hoy es tu cumplea�os");
		} else {
			System.out.println(" Hoy no es tu cumplea�os");
		}

		// Hora actual

		LocalTime hora = LocalTime.now();
		System.out.println("La hora actual es:" + hora);

		// Sumas y restas de cantidades de tiempo a una hora

		LocalTime horaNueva = hora.plusHours(2).plusMinutes(3);
		System.out.println("La hora nueva (+2 horas y + 3 minutos) es:" + horaNueva);

		LocalTime horaNueva1 = hora.plusHours(23).minusMinutes(3).plusSeconds(23).plusNanos(345);
		System.out.println("La hora nueva (+23 horas, -3 minutos, +23 segundos y +345 ns) es:" + horaNueva1);

		LocalTime horaNueva2 = hora.minus(1, ChronoUnit.HALF_DAYS);
		System.out.println("La hora hace medio d�a era:" + horaNueva2);

		// Sumas y restas de cantidades de tiempo a fechas

		LocalDate nextWeek = hoy.plus(1, ChronoUnit.WEEKS);
		LocalDate TwoWeeksAgo = hoy.minus(2, ChronoUnit.WEEKS);
		System.out.println("La pr�xima semana es:" + nextWeek);
		System.out.println("Hace dos semanas la fecha era:" + TwoWeeksAgo);

		// Comparaciones de fechas y horas -> isAfter, isBefore

		if (hoy.isAfter(TwoWeeksAgo)) {
			System.out.println("La fecha " + hoy + " es posterior a " + TwoWeeksAgo);
		}

		if (hoy.isBefore(nextWeek)) {
			System.out.println("La fecha " + hoy + " es anterior a " + nextWeek);
		}

		// Fechas de mes-a�o. Ej. Caducidad de una tarjeta de cr�dito

		YearMonth anioMesActual = YearMonth.now();

		System.out.println("La fecha en mes y año es: " + anioMesActual);
		YearMonth plazoEntregaProyecto = YearMonth.of(2022, Month.JULY);
		System.out.println("El plazo para entregar el proyecto es " + plazoEntregaProyecto);

		// A�o bisiesto

		if (hoy.isLeapYear()) {
			System.out.println("Este a�o es bisiesto");
		} else {
			System.out.println("Este a�o no es bisiesto");
		}

		// Periodos

		LocalDate diaNacimientoMaria = LocalDate.of(1980, Month.NOVEMBER, 23);

		Period periodoJuanMaria = Period.between(diaNacimientoJuan, diaNacimientoMaria);
		System.out.println("Entre el nacimiento de Juan y el de Mar�a hay " + periodoJuanMaria.getMonths() + " meses");

		// Formatos de fechas. parse

		String cadenaFecha = "22300112";
		LocalDate formatoNuevo = LocalDate.parse(cadenaFecha, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("La fecha generada a partir de la cadena %s es %s", cadenaFecha, formatoNuevo);
		System.out.println("");

		String cadenaFecha2 = "18-04-2020";

		try {
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate fechaLocalFormateada = LocalDate.parse(cadenaFecha2, formatoFecha);
			System.out.printf("La cadena %s ha sido formateada con �xito -> %s", cadenaFecha2, fechaLocalFormateada);

		} catch (DateTimeParseException infoExcepcion) {
			System.out.printf("La cadena %s no es formateable -> Corregir!", cadenaFecha2);
			infoExcepcion.printStackTrace();
		}

		// Formato de fechas para obtener cadenas de caracteres

		LocalDateTime fechaHoraActual = LocalDateTime.now();
		LocalDateTime fechaHoraNueva = fechaHoraActual.plusHours(2).plusMinutes(34);

		try {
			DateTimeFormatter formatoFechaCadena = DateTimeFormatter.ofPattern("MM yyyy, dd --> HH:mm:ss");
			String cadenaConFormato = fechaHoraActual.format(formatoFechaCadena);
			System.out.println(cadenaConFormato);

		} catch (DateTimeParseException infoExcepcion) {
			System.out.printf("La cadena %s no es formateable -> Corregir!", cadenaFecha2);
			infoExcepcion.printStackTrace();
		}

	}

}
