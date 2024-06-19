public class calculoDoacoes {
    private double totalDoado;
    private int numeroDoacoes;
  
  public calculoDoacoes() {
      this.totalDoado = 0;
      this.numeroDoacoes = 0;
  }
  public void adicionarDoacao(double valorDoacao) {
      if (valorDoacao <= 0) {
          throw new IllegalArgumentException("Valor da doação deve ser positivo.");
      }

      this.totalDoado += valorDoacao;
      this.numeroDoacoes++;
  }
  
  public double obterTotalDoado() {
      return this.totalDoado;
  } 
  public int obterNumeroDoacoes() {
      return this.numeroDoacoes;
  }
  
  public double obterMediaDoacoes() {
    if (this.numeroDoacoes == 0) {
        return 0;
    }
    return this.totalDoado / this.numeroDoacoes;
  }
}