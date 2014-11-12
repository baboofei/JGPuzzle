package gpuzzle.base;

import java.util.*;

public class GByte implements GObject
{
	public final GeneBase[] Bases;
	public final float Hash;

	public GByte(GeneBase[] bases)
	{
		this.Bases = bases;
		// TODO : implement the hashing feature
		this.Hash = 0;
	}

	public boolean Equals(GByte otherByte)
	{
		// TODO : This need to be rewritten to use something like the KMP algorithm
		throw new UnsupportedOperationException("Not implemented");	
	}

	public boolean QuickEquals(GByte otherByte)
	{
		// TODO : This is not going to WORK! It will always return true.
		throw new UnsupportedOperationException("Not implemented");	
	}

	public float Diff(GByte otherByte)
	{
		int countIdentical = 0;

		for(int i = 0; i < this.Bases.length; ++i)
		{
			if(this.Bases[i] == otherByte.Bases[i])	
			{
				++countIdentical;
			}
		}

		return (float)(countIdentical / this.Bases.length);
	}
}
