package gpuzzle.base;

import java.util.*;

public interface GCollection extends GObject
{
	abstract ListIterator GetContents();
	abstract ListIterator GetContents(int sizeBytes, GEndian endian);
	abstract int GetSize();
	abstract GCollection Clone();
}
