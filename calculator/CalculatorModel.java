package com.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel{

	private CalculatorView view;
	private ArrayList<Float> addNumbers = new ArrayList<>();
	private ArrayList<Float> subNumbers = new ArrayList<>();
	private ArrayList<Float> mulNumbers = new ArrayList<>();
	private ArrayList<Float> divNumbers = new ArrayList<>();

	CalculatorModel(CalculatorView view) {
		this.view=view;
	}

	public void addNumber(float number) {
		addNumbers.add(number);
	}

	public void subNumber(float number) {
		subNumbers.add(number);
	}

	public void mulNumber(float number) {
		mulNumbers.add(number);
	}

	public void divNumber(float number) {
		divNumbers.add(number);
	}

	public void addition() {
		String soln = "";
		float result = 0;
		for (int i = 0; i < addNumbers.size(); i++) {
			soln += addNumbers.get(i) + " + ";
			result += addNumbers.get(i);
		}
		soln = soln.substring(0, soln.length() - 2);
		view.result(soln, result);
	}

	public void subtraction() {
		String soln = "";
		float result = 0;
		for (int i = 0; i < subNumbers.size(); i++) {
			soln += subNumbers.get(i) + " - ";
			result -= subNumbers.get(i);
		}
		soln = soln.substring(0, soln.length() - 2);
		view.result(soln, result);
	}

	public void multiplication() {
		String soln = "";
		float result = 0;
		for (int i = 0; i < mulNumbers.size(); i++) {
			soln += mulNumbers.get(i) + " * ";
			result *= mulNumbers.get(i);
		}
		soln = soln.substring(0, soln.length() - 2);
		view.result(soln, result);
	}

	public void division() {
		String soln = "";
		float result = 0;
		for (int i = 0; i < mulNumbers.size(); i++) {
			soln += mulNumbers.get(i) + " / ";
			result /= mulNumbers.get(i);
		}
		soln = soln.substring(0, soln.length() - 2);
		view.result(soln, result);
	}

	public void expression(String expression) {
		String s = expression;
		List<Float> num = new ArrayList<Float>();
		List<Character> ch = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
				ch.add(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 <= s.length() - 1) {
				if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9') || s.charAt(i) == '.') {
					{
						String s1 = "";
						s1 += s.charAt(i);
						while (i + 1 < s.length() && ((s.charAt(i + 1) != '+' && s.charAt(i + 1) != '-'
								&& s.charAt(i + 1) != '*' && s.charAt(i + 1) != '/'))) {
							s1 += s.charAt(i + 1);
							i++;
						}
						num.add(Float.parseFloat(s1));
					}
				}
			} else if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
				num.add((float) (s.charAt(i) - '0'));
			}
		}

		System.out.println(num + " " + ch);

		float no1 = num.get(0);
		int k = 0;
		for (int i = 1; i < num.size(); i++, k++) {
			float no2 = num.get(i);
			if (ch.get(k) == '+')
				no1 = no1 + no2;
			else if (ch.get(k) == '-')
				no1 = no1 - no2;
			else if (ch.get(k) == '*')
				no1 = no1 * no2;
			else if (ch.get(k) == '/')
				no1 = no1 / no2;
		}
		view.result(expression, no1);
	}
}