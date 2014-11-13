package gpuzzle.base;

import java.util.*;

public class GSentence implements GCollection 
{
	private ArrayList<GByte> Contents;

	public GSentence(ListIterator<GByte> source)
	{
		this.Contents = new ArrayList<GByte>();

		while(source.hasNext())
		{
			Contents.add(source.next());
		}
	}

	public ListIterator<GByte> GetContents()
	{
		return this.Contents.listIterator();
	}	

	public ListIterator<GByte> GetContents(int sizeBytes, GEndian endian)
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

	// The following methods allows to compare / diff the GSentence object

	public boolean Equals(GSentence otherSentence)
	{
		// TODO : this need to be re-written to do something like the KMP algorithm
		throw new UnsupportedOperationException("Not implemented");	
	}

	public boolean QuickEquals(GSentence otherSentence)
	{
		throw new UnsupportedOperationException("Not implemented");
	}

	public float Diff(GSentence otherSentence)
	{
		ListIterator<GByte> otherSentenceBytes = otherSentence.GetContents();
		ListIterator<GByte> thisSentenceBytes = this.GetContents();

		int countIdentical = 0;

		while(thisSentenceBytes.hasNext())
		{
			if(thisSentenceBytes.next().Equals(otherSentenceBytes.next()))
			{
				++countIdentical;
			}	
		}	

		return (float)(countIdentical / this.Contents.size());
	}

	public float RecursiveDiff(GSentence otherSentence)
	{
		ListIterator<GByte> otherSentenceBytes = otherSentence.GetContents();
		ListIterator<GByte> thisSentenceBytes = this.GetContents();

		ArrayList<Float> diffList = new ArrayList<Float>();

		while(thisSentenceBytes.hasNext())
		{
			Float diffResult = thisSentenceBytes.next().Diff(otherSentenceBytes.next());
			diffList.add(diffResult);
		}

		double diffTotal = 0;

		for(Float diffContent : diffList)
		{
			diffTotal += diffContent;
		}

		return (float)(diffTotal / this.Contents.size());
	}

	public float QuickDiff(GSentence otherSentence)
	{
		ListIterator<GByte> otherSentenceBytes = otherSentence.GetContents();
		ListIterator<GByte> thisSentenceBytes = this.GetContents();

		int countIdentical = 0;

		while(thisSentenceBytes.hasNext())
		{
			if(thisSentenceBytes.next().QuickEquals(otherSentenceBytes.next()))
			{
				++countIdentical;
			}	
		}

		return (float)(countIdentical / this.Contents.size());
	}

	// The following methods manipulate the GSentence object

	public GSentence Sample(int sizeBytes, GEndian endian)
	{
		ListIterator<GByte> thisSentenceBytes = this.GetContents();
		ArrayList<GByte> newBytes = new ArrayList<GByte>();

		if(endian == GEndian.High)
		{
			while(thisSentenceBytes.hasNext())
			{
				thisSentenceBytes.next();
			}

			int currentBytesCount = 0;

			while(thisSentenceBytes.hasPrevious() && currentBytesCount < sizeBytes)
			{
				newBytes.add(thisSentenceBytes.previous());
				++currentBytesCount;
			}
		}
		else
		{
			int currentBytesCount = 0;

			while(thisSentenceBytes.hasNext() && currentBytesCount < sizeBytes)
			{
				newBytes.add(thisSentenceBytes.next());
				++currentBytesCount;
			}
		}

		return new GSentence(newBytes.listIterator());
	}	

	public GSentence Cut(int sizeBytes, GEndian endian)
	{
		GSentence result = this.Sample(sizeBytes, endian);

		if(endian == GEndian.High)
		{
			this.Contents.subList(this.Contents.size() - sizeBytes, this.Contents.size()).clear();
		}
		else
		{
			this.Contents.subList(0, sizeBytes).clear();	
		}

		return result;
	}

	public void Merge(int sizeBytes, GEndian endian, GSentence otherSentence)
	{
	}

}
