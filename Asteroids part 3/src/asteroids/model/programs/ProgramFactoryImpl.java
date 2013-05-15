package asteroids.model.programs;

import java.util.List;

import asteroids.model.programs.expressions.BooleanLiteral;
import asteroids.model.programs.expressions.DoubleLiteral;
import asteroids.model.programs.expressions.Expression;
import asteroids.model.programs.expressions.Null;
import asteroids.model.programs.expressions.Variable;
import asteroids.model.programs.parsing.ProgramFactory;
import asteroids.model.programs.statements.Assignment;
import asteroids.model.programs.statements.Fire;
import asteroids.model.programs.statements.If;
import asteroids.model.programs.statements.Print;
import asteroids.model.programs.statements.Sequence;
import asteroids.model.programs.statements.Skip;
import asteroids.model.programs.statements.Statement;
import asteroids.model.programs.statements.Thrust;
import asteroids.model.programs.statements.ThrustOff;
import asteroids.model.programs.statements.Turn;
import asteroids.model.programs.types.*;

@SuppressWarnings("unchecked")
public class ProgramFactoryImpl<E extends Expression, S extends Statement, T extends Type> implements ProgramFactory<E,S,T>{
	
	@Override
	public T createDoubleType() {
	   return (T) Type.DOUBLE;
	}

	@Override
	public T createBooleanType() {
		return (T) Type.BOOL;
	}

	@Override
	public T createEntityType() {
		return (T) Type.ENTITY;
	}

	@Override
	public E createDoubleLiteral(int line, int column, double d) {
		return (E) new DoubleLiteral(line, column, d);
	}

	@Override
	public E createBooleanLiteral(int line, int column, boolean b) {
		return (E) new BooleanLiteral(line, column, b);
	}

	//@Override
	//public E createAnd(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createOr(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createNot(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public E createNull(int line, int column) {
		return (E) new Null(line, column);
	}

	//@Override
	//public E createSelf(int line, int column) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetX(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetY(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetVX(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetVY(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetRadius(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public E createVariable(int line, int column, String name) {
		return (E) new Variable(line, column, name);
	}

	//@Override
	//public E createLessThan(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGreaterThan(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createLessThanOrEqualTo(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGreaterThanOrEqualTo(int line, int column, E e1, e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createEquality(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createInequality(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createAdd(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createSubtraction(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createMul(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createDivision(int line, int column, E e1, E e2) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createSqrt(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createGetDirection(int line, int column) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createSin(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	//@Override
	//public E createCos(int line, int column, E e) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public S createEnableThruster(int line, int column) {
		return (S) new Thrust(line, column);
	}

	@Override
	public S createDisableThruster(int line, int column) {
		return (S) new ThrustOff(line, column);
	}

	@Override
	public S createFire(int line, int column) {
		return (S) new Fire(line, column);
	}

	@Override
	public S createTurn(int line, int column, E angle) {
		return (S) new Turn(line, column, angle);
	}

	@Override
	public S createAssignment(int line, int column, String variable,E rhs) {
		Statement assignment = new Assignment(line, column, variable, rhs);
		return (S) assignment;
	}

	@Override
	public S createIf(int line, int column, E condition, S then, S otherwise) {
		return (S) new If(line, column, condition, then, otherwise);
	}
	
	//@Override
	//public S createWhile(int line, int column, E condition, S body) {
		//return null;
	//}
	
	//@Override
	//public S createForeach(int line, int column, ForeachType type, String variableName, S body) {
		//return null;
	//}

	@Override
	public S createSkip(int line, int column) {
		return (S) new Skip(line, column);
	}

	@Override
	public S createSequence(int line, int column, List<S> statements) {
		Statement sequence = new Sequence(line, column, (List<Statement>) statements);
		return (S) sequence;
	}

	@Override
	public S createPrint(int line, int column, E e) {
		return (S) new Print(line, column, e);
	}

}
