package gpuzzle.base;

import java.util.*;

public class GSegment implements GCollection
{
	private ArrayList<GeneBase> Contents;

	public GSegment(GeneBase[] contents)
	{
		for(int i = 0; i < contents.length; ++i)
		{
			this.Contents.add(contents[i]);
		}
	}

	public ListIterator<GeneBase> GetContents()
	{
		return this.Contents.listIterator();
	}

	public ListIterator<GeneBase> GetContents(int indexShift, GEndian endian)
	{
		if(endian == GEndian.Low)
		{
			return this.Contents.listIterator(indexShift);
		}
		else
		{
			ArrayList<GeneBase> resultList = new ArrayList<GeneBase>();

			Iterator<GeneBase> resultReversed = this.Contents.iterator();

			for(int i = 0; i < indexShift; ++i)
			{
				resultList.add(resultReversed.next());
			}

			return resultList.listIterator();
		}
	}

	public GSentence ToGSentence()
	{
		// TODO : Implement this as slicing the GeneBases into GBytes
		throw new UnsupportedOperationException("Not implemented");	
	}
}
