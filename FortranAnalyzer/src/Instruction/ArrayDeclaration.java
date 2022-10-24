package Instruction;

import Ambit.Ambit;
import Expression.*;
import ThreeWayCode.ThreeWayCode;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayDeclaration extends Instruction{

    private String id;
    public String line;
    public String column;
    public int size;
    public ArrayList<Object> values;
    public ReturnType type;

    public ArrayDeclaration(String id, ArrayList<Object> values,int size,ReturnType type, String line, String column){
        super(line, column);
        this.values=values;
        this.id=id.toUpperCase();
        this.size=size;
        this.type=type;
        this.line=line;
        this.column=column;
    }

    public Object execute(Ambit ambit) {
        ambit.newArrayOneDim(this.id, this.values, this.type, this.line, this.column);
        ambit.sizeOneDim(this.id,this.size);
        return true;
    }

    public Object c3d(Ambit ambit){
        //System.out.println(this.type);
        ThreeWayCode threeWayCodeHandler=ThreeWayCode.getInstance();
        if(Objects.equals(this.type.toString(), "INTEGER")){
            threeWayCodeHandler.mainCode+="double "+this.id+"["+(this.size)+"];\n";
        }else if(Objects.equals(this.type.toString(), "REAL")){
            threeWayCodeHandler.mainCode+="double "+this.id+"["+(this.size)+"];\n";

        }else if(Objects.equals(this.type.toString(), "CHARACTER")){
            threeWayCodeHandler.mainCode+="double "+this.id+"["+(this.size)+"];\n";
        }
        return null;
    }
}
