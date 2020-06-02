
public class FileSystemAltoNivel {
	
	//Nos gustaría que este API eventualmente pudiera tener diferentes implementaciones que hablen 
	//contra otros sistemas de archivos con otras interfaces de bajo nivel.
	int descriptorArchivoActual;
	
	void abrirArchivo(InterfazFileSystem unFileSystem, String directorio) {
		descriptorArchivoActual = unFileSystem.openFile(directorio);
	}
	
	void cerrarArchivo(InterfazFileSystem unFileSystem) {
		unFileSystem.closeFile(descriptorArchivoActual);
	}
	
	int leerSincronico(InterfazFileSystem unFileSystem, Buffer buffer) {
		return unFileSystem.syncReadFile(descriptorArchivoActual, buffer.getBufferBytes(), buffer.getBufferStart(), buffer.getBufferEnd());
	}
	
	void escribirSincronico(InterfazFileSystem unFileSystem, Buffer buffer) {
		unFileSystem.syncWriteFile(descriptorArchivoActual, buffer.getBufferBytes(), buffer.getBufferStart(), buffer.getBufferEnd());
	}
	
	void leerAsincronico(InterfazFileSystem unFileSystem, Buffer buffer, Consumer<Integer> callback) {
		unFileSystem.asyncReadFile(descriptorArchivoActual, buffer.getBufferBytes(), buffer.getBufferStart(), buffer.getBufferEnd(), Consumer<Integer> callback);
				//no entiendo muy bien lo del callback, tampoco me queda claro si me falta alguna abstracción acá
	}
}
