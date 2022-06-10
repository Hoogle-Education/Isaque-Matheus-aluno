package question3;

import java.util.concurrent.Semaphore;

public class Buffer {
	
	final int SIZE_OF_QUEUE;
	Object buffer[];
	private volatile int[] age;

	Semaphore isFull;
	Semaphore isEmpty;
	Semaphore useQueue;
	
	int head;
	int tail;

	public Buffer(int size)
	{
		SIZE_OF_QUEUE = size;
		buffer 			= new Object[SIZE_OF_QUEUE];
		age         = new int[SIZE_OF_QUEUE];

		isFull 			= new Semaphore(0);
		isEmpty 		= new Semaphore(SIZE_OF_QUEUE);
		useQueue = new Semaphore(1);

		head=0;
		tail=0;
	}

	public void insert(Object item)
	{
		try {
			isEmpty.acquire();
			useQueue.acquire();
		} catch (InterruptedException e) {
		}
		// putItemIntoQueue(item)

		buffer[tail] = item;
		age[tail] = 0;

		tail = (tail + 1 == buffer.length) ? tail : tail+1 ;

		for(int i=0; i<buffer.length; i++){
			if(buffer[i] == null) continue;

			int greatestIdIndex = i;

			for(int j=i+1; j<buffer.length;j++){
				if(buffer[j] == null) continue;

				if(getID(buffer[greatestIdIndex])*age[greatestIdIndex] < getID(buffer[j])*age[j]){
					greatestIdIndex = j;
				}
			}

			Object tempBuffer = buffer[greatestIdIndex];
			buffer[greatestIdIndex] = buffer[i];
			buffer[i] = tempBuffer;

			int tempAge = age[greatestIdIndex];
			age[greatestIdIndex] = age[i];
			age[i] = tempAge;
		}

		useQueue.release();
		isFull.release();

	}


	public Object remove()
	{
		try {
			isFull.acquire();
			useQueue.acquire();
		} catch (InterruptedException e) {
		}

		
		// item <- getItemFromQueue(item)
		Object item = buffer[head];
		head = (head+ 1) % SIZE_OF_QUEUE;
		
		useQueue.release();
		isEmpty.release();
		
		for(int i=0; i<buffer.length; i++){
			if(buffer[i] != null) age[i]++;
		}

		return item;
	}

	private int getID(Object buffer){ 
		return Integer.parseInt(((String)buffer).split("#")[1]);
	}

}