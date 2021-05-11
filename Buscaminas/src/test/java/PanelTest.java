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
	void initImages() {
		System.out.println("0");

	}

	@Test
	void initBoxes() {

	}

	@Test
	void paintPanel() {

	}

	@Test
	void paintGrid() {

	}

	@Test
	void boxPressed() {

	}

	@Test
	void openPanel() {

	}

	@Test
	void open() {

	}

	@Test
	void canOpen() {

	}

	@Test
	void findBombsAround() {

	}

	@Test
	void checkLimit() {

	}

	@Test
	void showBombs() {

	}

}