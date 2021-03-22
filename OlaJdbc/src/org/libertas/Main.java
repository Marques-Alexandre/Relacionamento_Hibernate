package org.libertas;

import java.util.List;
import java.util.Scanner;

import org.libertas.dao.PessoaDaoHibernate;
import org.libertas.dao.PessoaDaoJdbc;
import org.libertas.model.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			
			Scanner in = new Scanner(System.in);
			
			int menu = 0;
			
			while (menu != 6) {
				System.out.println("Cadastro de Pessoas");
				System.out.println("Selecione a sua opção: ");
				System.out.println("1 - inserir");
				System.out.println("2 - alterar");
				System.out.println("3 - excluir");
				System.out.println("4 - consultar");
				System.out.println("5 - listar");
				System.out.println("6 - sair");
				
				menu = Integer.parseInt(in.nextLine());
				
				switch (menu) {
				case 1: {
					inserir(in);
					break;
				} case 2: {
					alterar(in);
					break;
				} case 3: {
					excluir(in);
					break;
				} case 4: {
					consultar(in);
					break;
				} case 5: {
					listar(in);
					break;
				} case 6: {
					System.out.println("fim");
					break;
				} default:
					System.out.println("Opção Inválida");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void listar(Scanner in) {
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		List<Pessoa> lista = pdao.listar();
		for (Pessoa p : lista) {
			System.out.println(p);
		}
	}

	private static void consultar(Scanner in) {
		System.out.println("Digite o código desejado: ");
		int id = Integer.parseInt(in.nextLine());
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		Pessoa p = pdao.consultar(id);
		System.out.println(p);
	}

	private static void excluir(Scanner in) {
		System.out.println("Digite o código que deseja excluir: ");
		int id = Integer.parseInt(in.nextLine());
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		Pessoa p = new Pessoa();
		p.setIdpessoa(id);
		pdao.excluir(p);
	}

	private static void alterar(Scanner in) {
		Pessoa p = new Pessoa();

		System.out.println("idpessoa: ");
		p.setIdpessoa(Integer.parseInt(in.nextLine()));
		
		System.out.println("Nome: ");
		p.setNome(in.nextLine());
		
		System.out.println("Telefone: ");
		p.setTelefone(in.nextLine());
		
		System.out.println("Email: ");
		p.setEmail(in.nextLine());
		
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		pdao.alterar(p);
	}

	private static void inserir(Scanner in) {
		Pessoa p = new Pessoa();

		System.out.println("Nome: ");
		p.setNome(in.nextLine());
		
		System.out.println("Telefone: ");
		p.setTelefone(in.nextLine());
		
		System.out.println("Email: ");
		p.setEmail(in.nextLine());
		
		PessoaDaoHibernate pdao = new PessoaDaoHibernate();
		pdao.inserir(p);
		
	}
	
}
