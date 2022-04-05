module dev.kalenchukov.injector
{
	requires org.jetbrains.annotations;
	requires log4j;

	exports dev.kalenchukov.fieldvalueinjector;
	exports dev.kalenchukov.fieldvalueinjector.annotations;
	exports dev.kalenchukov.fieldvalueinjector.exceptions;
}