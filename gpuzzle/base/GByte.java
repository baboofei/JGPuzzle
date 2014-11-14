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
		if(this.Bases.length == otherByte.Bases.length)
		{
			for(int i = 0; i < this.Bases.length; ++i)
			{
				if(this.Bases[i] != otherByte.Bases[i])
				{
					return false;
				}
			}

			return true;
		}	
		else
		{
			return false;
		}
	}

	public boolean QuickEquals(GByte otherByte)
	{
		return this.Hash == otherByte.Hash;
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
