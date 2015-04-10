package com.mdsgpp.eef.testeUI;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class testeUI extends UiAutomatorTestCase {

	public void test() throws UiObjectNotFoundException {
		UiObject botaoMenu, tabApps, botaoEEF, opcaoListaEstados, itemMatoGrosso, txtViewSigla;
		UiScrollable scrollApps, scrollListaEstados;
		
		getUiDevice().pressHome();

		botaoMenu = new UiObject(new UiSelector().index(4).description("Apps"));
		botaoMenu.clickAndWaitForNewWindow();

		tabApps = new UiObject(new UiSelector().index(0).text("Apps"));
		tabApps.click();

		scrollApps = new UiScrollable(new UiSelector().scrollable(true));
		botaoEEF = new UiObject(new UiSelector().text("EEF"));
		
		while (!botaoEEF.exists()) {
			scrollApps.swipeLeft(50);
		}
		
		botaoEEF.clickAndWaitForNewWindow();
		
		opcaoListaEstados = new UiObject(new UiSelector().text("Lista de Estados"));
		opcaoListaEstados.clickAndWaitForNewWindow();
		
		scrollListaEstados = new UiScrollable(new UiSelector().scrollable(true));
		scrollListaEstados.scrollTextIntoView("Mato Grosso");
		
		itemMatoGrosso = scrollListaEstados.getChildByText(new UiSelector().
				className(android.widget.TextView.class.getName()), "Mato Grosso");
		itemMatoGrosso.clickAndWaitForNewWindow();
		
		txtViewSigla = new UiObject(new UiSelector().className("android.widget.TextView").index(1));
		assertEquals("MT", txtViewSigla.getText());
	}
}