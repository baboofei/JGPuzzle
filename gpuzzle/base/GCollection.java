package gpuzzle.base;

import java.util.*;

public interface GCollection extends GObject
{
	abstract ListIterator GetContents();
	abstract ListIterator GetContents(int indexShift, GEndian endian);
}