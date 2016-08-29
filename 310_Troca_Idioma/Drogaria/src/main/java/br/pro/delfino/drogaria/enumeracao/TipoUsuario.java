package br.pro.delfino.drogaria.enumeracao;

public enum TipoUsuario {
	ADMINISTRADOR, GERENTE, BALCONISTA;

	@Override
	public String toString() {
		switch (this) {
		case ADMINISTRADOR:
			return "Administrador";
		case GERENTE:
			return "Gerente";
		case BALCONISTA:
			return "Balconista";
		default:
			return null;
		}
	}
}
