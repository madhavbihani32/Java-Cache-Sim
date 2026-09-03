package cpu_cache_sim;

public class CacheLine {
	private int tag;
	private boolean valid;
	private byte[] data;
	
//	private int AddressToTag(int address)
//	{
//		//we have 6 bit addresses, so the first 2 bits would represent the tag, so remaining 4 bits 
//		//have a decimal representation of 2^3 = 8.
//		return address/16;
//		
//	}
	public CacheLine()
	{
		//create an empty cacheline.
		valid = false;
		tag = -1;
		data = new byte[4];
	}
	public void AssignCacheLine(int tag, MainMemory mem, int memline)
	{
		this.tag = tag;
		valid = true;
		byte[] temp = mem.readLine(memline);
		//now, we have to copy the data block from the main memory to this object's "data" array;
		for(int i = 0; i<4 ; i++)
		{			
			data[i] =  temp[i];
		}
	}
	public int GetTag()
	{
		return this.tag;
	}
	public boolean IsValid()
	{
		return valid;
	}
	public byte Fetch(int offset)
	{
		if(offset > 3)
		{
			System.err.println("Tried Accessing invalid Offset of CacheLine, fetch request denied");
			return -2;
		}
		else return data[offset];
	}
	
	
}
