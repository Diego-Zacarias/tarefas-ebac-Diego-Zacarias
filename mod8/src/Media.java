
public class Media {
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double media;
	public Media(double nota1, double nota2, double nota3, double nota4) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		
		this.calcularMedia();
	}
	
	private void calcularMedia() {
		this.media = (nota1 + nota2 + nota3 + nota4)/4;
	}

	public double getMedia() {
		return media;
	}

}
