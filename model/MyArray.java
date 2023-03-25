package model;

import java.util.ArrayList;
import java.util.List;

//MyArray phai extends tu thang Observer vi no la thang thay doi khi ma bi tac dong
//thang extends subject la nhuwng thang nguyen nhan dan den su thay doi ve mang
//nhu them,xoa,sua,so dinh
public class MyArray implements Observer {
	ICreateArray createArray;
	int[][] myArray;
	Subject subject;

	public MyArray(Subject subject, ICreateArray createArray) {
		this.subject = subject;
		subject.registerObserver(this);
		this.createArray = createArray;
	}

	public void setCreateArray(ICreateArray createArray) {
		this.createArray = createArray;
	}

	public int[][] getArray() {
		return myArray;
	}

	@Override
	public void update(int crSize) {
		myArray = this.createArray.createArr(crSize);
	}
}
