import exceptions.BombsRebaseNumberOfBoxesException;
import javafx.beans.binding.When;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PanelTest {

	@Spy
	private Panel spyPanel;

	@Mock
	private Image mockImage;

	@Mock
	private List<List<Box>> mockList2;

	@Mock
	private List<Box> mockList;

	/**
	 * Para los Mocks hay que usar "when" y para los spy usamos los "doReturn", "do...", etc...
	 */
	@Test
	void initBombsAround() {

		// Preparation
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setBoxes(mockList2);
		Box spyBox = spy(new Box(this.mockImage, this.mockImage));

		when(this.spyPanel.boxes.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		doReturn(1).when(this.spyPanel).findBombsAround(anyInt(), anyInt());

		// Execution
		spyPanel.initBombsAround();
		verify(spyBox, times(100)).setBombsAround(anyInt());
	}

	@Test
	void initBombsTest() {

		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setNumBombs(200);
		assertThrows(BombsRebaseNumberOfBoxesException.class, () -> {

			this.spyPanel.initBombs();
		});
	}

	@Test
	void plantBombs() throws BombsRebaseNumberOfBoxesException {

		Box spyBox = spy(new Box(this.mockImage, this.mockImage));
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setNumBombs(10);
		this.spyPanel.setBoxes(this.mockList2);

		when(mockList2.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		//doReturn(false).when(spyBox.isBomb());
		when(spyBox.isBomb()).thenReturn(false);

		this.spyPanel.plantBombs();
		verify(spyBox, times(10)).setBomb(true);
	}

	@Test
	void initImagesTest() {

	}

	@Test
	void initBoxesTest() {

	}

	@Test
	void paintPanelTest() {

	}

	@Test
	void paintGridTest() {

	}

	@Test
	void boxPressedTest() {

	}

	@Test
	void openPanelTest() {

	}

	@Test
	void openTest() {

		Box spyBox = spy(new Box(this.mockImage, this.mockImage));
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setBoxes(this.mockList2);

		when(mockList2.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		when(spyBox.getBombsAround()).thenReturn(0);
		doNothing().when(this.spyPanel).openPanel(anyInt(), anyInt());

		this.spyPanel.open(5, 6);
		verify(this.spyPanel, times(4)).openPanel(anyInt(), anyInt());

		this.spyPanel.open(-5, 0);
		verify(this.spyPanel, times(4)).openPanel(anyInt(), anyInt());

		this.spyPanel.open(50, 2);
		verify(this.spyPanel, times(4)).openPanel(anyInt(), anyInt());

		this.spyPanel.open(50, 22);
		verify(this.spyPanel, times(4)).openPanel(anyInt(), anyInt());
	}

	@Test
	void canOpenTest() {

		Box spyBox = spy(new Box(this.mockImage, this.mockImage));
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setBoxes(this.mockList2);

		assertFalse(this.spyPanel.canOpen(-5, 5));
		verify(this.spyPanel, times(1)).isBoxOnLimits(anyInt(), anyInt());
		verify(spyBox, times(0)).isVisible();


		when(this.spyPanel.boxes.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		when(spyBox.getBombsAround()).thenReturn(0);
		when(spyBox.isVisible()).thenReturn(false);

		assertTrue(this.spyPanel.canOpen(5, 5));
		verify(spyBox, times(1)).isVisible();
		verify(spyBox, times(1)).getBombsAround();
		verify(spyBox, times(0)).setVisible(true);


		when(spyBox.getBombsAround()).thenReturn(1);

		assertFalse(this.spyPanel.canOpen(5, 6));
		verify(spyBox, times(2)).getBombsAround();
		verify(spyBox, times(2)).getBombsAround();
		verify(spyBox, times(1)).setVisible(true);
	}

	@Test
	void findBombsAroundTest() {

		doReturn(true).when(this.spyPanel).isBomb(1, 1);
		assertEquals(-1, this.spyPanel.findBombsAround(1, 1));


		Box spyBox = spy(new Box(this.mockImage, this.mockImage));
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setBoxes(this.mockList2);
		when(this.spyPanel.boxes.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		doReturn(false).when(this.spyPanel).isBomb(1, 1);
		spyBox.setBomb(true);

		assertEquals(8, this.spyPanel.findBombsAround(1, 1));
	}

	@Test
	void isBombTest() {

		Box spyBox = spy(new Box(this.mockImage, this.mockImage));
		this.spyPanel.setDimension(new Dimension(10, 10));
		this.spyPanel.setBoxes(this.mockList2);
		when(this.spyPanel.boxes.get(anyInt())).thenReturn(this.mockList);
		when(this.mockList.get(anyInt())).thenReturn(spyBox);
		spyBox.setBomb(true);

		assertTrue(this.spyPanel.isBomb(1, 1));

		spyBox.setBomb(false);

		assertFalse(this.spyPanel.isBomb(1, 1));
	}

	@Test
	void checkLimitTest() {

		this.spyPanel.setDimension(new Dimension(10, 10));

		assertEquals(5, this.spyPanel.checkLimit(6, false));
		assertEquals(7, this.spyPanel.checkLimit(6, true));
		assertEquals(-5, this.spyPanel.checkLimit(-5, false));
		assertEquals(-4, this.spyPanel.checkLimit(-5, true));
		assertEquals(19, this.spyPanel.checkLimit(20, false));
		assertEquals(20, this.spyPanel.checkLimit(20, true));
	}

	@Test
	void showBombsTest() {

	}

	@Test
	void isBoxOnLimitsTest() {

		this.spyPanel.setDimension(new Dimension(10, 10));
		assertTrue(this.spyPanel.isBoxOnLimits(-5, 5));
		assertTrue(this.spyPanel.isBoxOnLimits(5, -5));
		assertFalse(this.spyPanel.isBoxOnLimits(5, 5));
		assertFalse(this.spyPanel.isBoxOnLimits(0, 9));

	}

}