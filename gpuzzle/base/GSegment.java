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

	public ListIterator<GeneBase> GetContents(int sizeBytes, GEndian endian)
	{
		if(endian == GEndian.Low)
		{
			return this.Contents.subList(0, sizeBytes).listIterator();
		}
		else
		{
			return this.Contents.subList(this.Contents.size() - sizeBytes, this.Contents.size()).listIterator();
		}
	}

	public GSentence ToGSentence()
	{
		// TODO : Implement this as slicing the GeneBases into GBytes
		throw new UnsupportedOperationException("Not implemented");	
	}
}
