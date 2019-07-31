package app.sonnet;

import app.poem.Poem;

public class Sonnet29 implements Poem {

	private static final String[] LINES = {
				"����� � ������� � ����� � �������,",
				"��������� ����, ������ �������,",
				"������� � ���������� �������", 
				"������ � ����������� ��������",
				"�, ������� �� ��������� ����,",
				"����� �������� ������� �����",
				"� ���, ��� � ��������� ������ ��������,",
				"����� �������� � ������ �����, -",
				"�����, �������� �������� � ����,",
				"� ��������� ������ �����,",
				"� ����������, ������� ������,",
				"��� ���� ������� � ������.",
				"� ����� �������, � ������� � ���",
				"���� ������� �� ����� � �������."
			};

	public void recite() {
		for (int i = 0; i < LINES.length; i++) {
			System.out.println(LINES[i]);
		}
	}

}
