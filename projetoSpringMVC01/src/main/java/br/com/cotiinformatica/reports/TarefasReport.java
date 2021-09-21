package br.com.cotiinformatica.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.DateHelper;

public class TarefasReport {

	// m�todo para gerar o conteudo do relatorio
	// ByteArrayInputStream -> retornar um arquivo em mem�ria
	public static ByteArrayInputStream getPdf(Date dataMin, Date dataMax, List<Tarefa> tarefas, Usuario usuario)
			throws Exception {

		// criando o documento PDF com o itext
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter pdf = PdfWriter.getInstance(document, out);

		// abrir o documento PDF
		document.open();

		Image img = Image.getInstance(new URL("https://www.cotiinformatica.com.br/imagens/logo-coti-informatica.png"));
		document.add(img);

		document.add(new Paragraph("Relat�rio de tarefas", formatarTitulo()));
		document.add(new Paragraph("\n"));

		document.add(new Paragraph("Nome do Usu�rio: " + usuario.getNome(), formatarTexto()));
		document.add(new Paragraph("Email do Usu�rio: " + usuario.getEmail(), formatarTexto()));

		document.add(new Paragraph("Data de In�cio: " + DateHelper.toStringPtBr(dataMin), formatarTexto()));
		document.add(new Paragraph("Data de T�rmino: " + DateHelper.toStringPtBr(dataMax), formatarTexto()));

		document.add(new Paragraph("\n"));

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);

		table.addCell(new Paragraph("Nome da tarefa", formatarCelulaTitulo()));
		table.addCell(new Paragraph("Data", formatarCelulaTitulo()));
		table.addCell(new Paragraph("Hora", formatarCelulaTitulo()));
		table.addCell(new Paragraph("Descri��o", formatarCelulaTitulo()));
		table.addCell(new Paragraph("Prioridade", formatarCelulaTitulo()));

		for (Tarefa tarefa : tarefas) {

			table.addCell(new Paragraph(tarefa.getNome(), formatarCelula()));
			table.addCell(new Paragraph(DateHelper.toStringPtBr(tarefa.getData()), formatarCelula()));
			table.addCell(new Paragraph(tarefa.getHora(), formatarCelula()));
			table.addCell(new Paragraph(tarefa.getDescricao(), formatarCelula()));
			table.addCell(new Paragraph(tarefa.getPrioridade().toString(), formatarCelula()));
		}

		document.add(table);

		document.add(new Paragraph("\n"));

		document.add(new Paragraph("Quantidade de tarefas: " + tarefas.size(), formatarTexto()));
		document.add(new Paragraph("Relat�rio gerado em: " + DateHelper.toStringPtBr(new Date()), formatarTexto()));

		document.close();
		pdf.close();

		return new ByteArrayInputStream(out.toByteArray());
	}

	// m�todo para formatar o titulo do relatorio
	private static Font formatarTitulo() {

		Font font = new Font();

		font.setSize(18);
		font.setStyle("bold");
		font.setColor(15, 60, 120); // RGB

		return font;
	}

	// m�todo para formatar o titulo do relatorio
	private static Font formatarTexto() {

		Font font = new Font();

		font.setSize(10);
		font.setColor(0, 0, 0); // RGB

		return font;
	}

	// m�todo para formatar o titulo do relatorio
	private static Font formatarCelulaTitulo() {

		Font font = new Font();

		font.setSize(10);
		font.setStyle("bold");
		font.setColor(0, 0, 0); // RGB

		return font;
	}

	// m�todo para formatar o titulo do relatorio
	private static Font formatarCelula() {

		Font font = new Font();

		font.setSize(9);
		font.setColor(0, 0, 0); // RGB

		return font;
	}

}
