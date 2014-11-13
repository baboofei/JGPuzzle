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

	// Return a ListIterator object containing all GeneBases in this.Contents
	public ListIterator<GeneBase> GetContents()
	{
		return this.Contents.listIterator();
	}

	// Return a ListIterator object containing all GeneBases in this.Contents with given size and endian
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

	// Return current size
	public int GetSize()
	{
		return this.Contents.size();
	}

	// Creates a GSentence object and convert all current GeneBases in this.Contents to GBytes
	public GSentence ToGSentence(int byteSize, int modPolicy)
	{
		// byteSize is the size of byte in the GSentence object. All GBytes will have size byteSize
		// modPolicy determines how will the method treat the 'extra' GeneBases at the beginning / ending of the GSegment
		// 0 for default (remove at the end), 1 for remove at the end, 2 for remove at the front, 3 for return empty GSentence if any byte are to be left over

		// TODO : Actually implement the modPolicy feature

		ArrayList<GByte> resultBytes = new ArrayList<GByte>();

		for(int currentBasePosition = 0; currentBasePosition < this.Contents.size() && currentBasePosition + byteSize <= this.Contents.size(); currentBasePosition += byteSize)
		{
			GeneBase[] currentByteBases = new GeneBase[byteSize];			
			
			this.Contents.subList(currentBasePosition, currentBasePosition + byteSize).toArray(currentByteBases);

			resultBytes.add(new GByte(currentByteBases));
		}

		return new GSentence(resultBytes.listIterator());
	}
}
