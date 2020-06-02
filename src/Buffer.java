
public class Buffer {
	byte[] bufferBytes;
	int bufferStart;
	int bufferEnd;
	
	public Buffer(int bytes) {
		this.bufferBytes = bytes; //Esto está mal, pero no sé cómo asignarle la cantidad de bytes a esta variable
		this.bufferStart = 0;
		this.bufferEnd = bytes - 1; 
	}
}
