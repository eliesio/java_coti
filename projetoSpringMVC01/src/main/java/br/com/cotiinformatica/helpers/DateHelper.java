package br.com.cotiinformatica.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	// método para receber uma string no formato yyyy-MM-dd
	// e converte-la para o tipo java.util.Date
	public static Date toDate(String data) {

		int ano = Integer.parseInt(data.substring(0, 4));
		int mes = Integer.parseInt(data.substring(5, 7));
		int dia = Integer.parseInt(data.substring(8, 10));

		Calendar calendar = new GregorianCalendar(ano, mes - 1, dia);
		return calendar.getTime();
	}

	// método para receber uma data do java (java.util.Date)
	// e retorna-la como string no padrão yyyy-MM-dd
	public static String toString(Date data) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(data);
	}
}
