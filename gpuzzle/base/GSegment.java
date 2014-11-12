package gpuzzle.base;

import java.util.*;

public class GSegment implements GCollection
{
	private ArrayList<GByte> Contents;

	public GSegment(GByte[] contents)
	{
		for(int i = 0; i < contents.length; ++i)
		{
			this.Contents.add(contents[i]);
		}
	}

	public ListIterator<GByte> GetContents()
	{
		return this.Contents.listIterator();
	}

	public ListIterator<GByte> GetContents(int indexShift, GEndian endian)
	{
		if(endian == GEndian.Low)
		{
			return this.Contents.listIterator(indexShift);
		}
		else
		{
			ArrayList<GByte> resultList = new ArrayList<GByte>();

			Iterator<GByte> resultReversed = this.Contents.iterator();

			for(int i = 0; i < indexShift; ++i)
			{
				resultList.add(resultReversed.next());
			}

			return resultList.listIterator();
		}
	}

	public GSentence ToGSentence()
	{
		return new GSentence(this.GetContents());
	}
}
