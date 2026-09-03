package cpu_cache_sim;

public class MainMemory {
	private byte[][] mem;
	private int AddressToMemLine(int address)
	{
		return address/4;
	}
	private int AddressToOffset(int address)
	{
		int temp = address;
		return temp % 4;
	}
	public MainMemory()
	{
		mem = new byte[16][4]; // 16 lines having 4 quanta each;
	}

	public byte read(int address)
	{
		int memline = AddressToMemLine(address);
		int offset = AddressToOffset(address);
		return mem[memline][offset];
	}
	public void write(int address, byte value)
	{
		int memline = AddressToMemLine(address);
		int offset = AddressToOffset(address);
		mem[memline][offset] = value;
	}
	public byte[] readLine(int lineidx)
	{
		byte[] line = new byte[4];
		for( int i = 0; i<4; i++)
		{
			line[i] = mem[lineidx][i];
		}
		return line;
		
	}
	
	
}
