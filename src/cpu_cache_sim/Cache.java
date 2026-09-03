package cpu_cache_sim;

public class Cache {
	private CacheLine[] CM; //CM: Cache Memory
	public long hits;
	public long total;
	public Cache()
	{
		CM = new CacheLine[4];
		hits = 0;
		total = 0;
		for(int i =0; i<4;i++)
		{
			CM[i] = new CacheLine();
		}
		//we have 64 blocks of memory, with 4 quantum each, so 16 lines in the main memory.
		// first four lines form the first block of MM (main memory), and so on.
	}
	private int AddressToMemLine(int address)
	{
		return address/4;
	}
	private int AddressToTag(int address)
	{
		//we have 6 bit addresses, so the first 2 bits would represent the tag, so remaining 4 bits 
		//have a decimal representation of 2^3 = 8.
		return address/16;
	}
	private int AddressToIndex(int address)
	{
		int temp = address;
		temp = temp/4;
		return temp%4; //returns the middle two bits of the address.
		
	}
	private int AddressToOffset(int address)
	{
		int temp = address;
		return temp % 4;
	}

	public byte DataFetch(int address, MainMemory mem)
	{
		// so this will extract the middle 2 bits of the address, which represents the line index of 
		// the cache memory, and then check the tag associated with that cache line. If the tag matches,
		// it would mean that the requested data is present in the cache memory, so then the last 2 bits of
		// the address can be used to fetch it from cacheline[i].data
		int index = AddressToIndex(address);
		int tag = AddressToTag(address); // tag of the main memory
		int offset = AddressToOffset(address);
		int memline = AddressToMemLine(address); // line number of the main memory
		if( CM[index].IsValid() == true && CM[index].GetTag() == tag )
		{
			// Cache Hit!!
			hits++; total++;
			return CM[index].Fetch(offset);
		}
		else
		{
			// load cache line with the memory address requested, and then supply the data at the offset.
			total++;
			CM[index].AssignCacheLine( tag, mem, memline );
			return CM[index].Fetch(offset);
		}
	}
	
	
}
