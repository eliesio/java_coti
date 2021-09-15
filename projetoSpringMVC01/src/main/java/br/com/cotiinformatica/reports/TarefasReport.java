package br.com.cotiinformatica.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.helpers.DateHelper;

public class TarefasReport {

	// método para gerar o conteudo do relatorio
	// ByteArrayInputStream -> retornar um arquivo em memória
	public static ByteArrayInputStream getPdf(List<Tarefa> tarefas) throws Exception {

		// criando o documento PDF com o itext
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter pdf = PdfWriter.getInstance(document, out);

		// abrir o documento PDF
		document.open();

		document.add(new Paragraph("Relatório de tarefas\n"));

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);

		table.addCell("Nome da tarefa");
		table.addCell("Data");
		table.addCell("Hora");
		table.addCell("Descrição");
		table.addCell("Prioridade");

		for (Tarefa tarefa : tarefas) {

			table.addCell(tarefa.getNome());
			table.addCell(DateHelper.toString(tarefa.getData()));
			table.addCell(tarefa.getHora());
			table.addCell(tarefa.getDescricao());
			table.addCell(tarefa.getPrioridade().toString());
		}

		document.add(table);

		document.close();
		pdf.close();

		return new ByteArrayInputStream(out.toByteArray());
	}

}
