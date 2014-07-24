package com.tibco.as.io.simulation;

import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.tibco.as.io.simulation.provider.AddressLine2Provider;
import com.tibco.as.io.simulation.provider.AddressProvider;
import com.tibco.as.io.simulation.provider.BirthDateProvider;
import com.tibco.as.io.simulation.provider.BlobProvider;
import com.tibco.as.io.simulation.provider.BooleanProvider;
import com.tibco.as.io.simulation.provider.BusinessNameProvider;
import com.tibco.as.io.simulation.provider.CharProvider;
import com.tibco.as.io.simulation.provider.CityProvider;
import com.tibco.as.io.simulation.provider.ConstantProvider;
import com.tibco.as.io.simulation.provider.DateTimeProvider;
import com.tibco.as.io.simulation.provider.DoubleProvider;
import com.tibco.as.io.simulation.provider.EmailAddressProvider;
import com.tibco.as.io.simulation.provider.FirstNameProvider;
import com.tibco.as.io.simulation.provider.FloatProvider;
import com.tibco.as.io.simulation.provider.IntegerProvider;
import com.tibco.as.io.simulation.provider.ItemProvider;
import com.tibco.as.io.simulation.provider.LastNameProvider;
import com.tibco.as.io.simulation.provider.LongProvider;
import com.tibco.as.io.simulation.provider.NameProvider;
import com.tibco.as.io.simulation.provider.NowProvider;
import com.tibco.as.io.simulation.provider.NumberTextProvider;
import com.tibco.as.io.simulation.provider.PrefixProvider;
import com.tibco.as.io.simulation.provider.RandomCharsProvider;
import com.tibco.as.io.simulation.provider.RandomTextProvider;
import com.tibco.as.io.simulation.provider.RandomWordProvider;
import com.tibco.as.io.simulation.provider.RandomWordsProvider;
import com.tibco.as.io.simulation.provider.RegexProvider;
import com.tibco.as.io.simulation.provider.SequenceProvider;
import com.tibco.as.io.simulation.provider.ShortProvider;
import com.tibco.as.io.simulation.provider.StreetNameProvider;
import com.tibco.as.io.simulation.provider.StreetSuffixProvider;
import com.tibco.as.io.simulation.provider.SuffixProvider;

public class ValueProviderFactory {

	private Random random;

	private DataFactory df;

	public ValueProviderFactory(DataFactory dataFactory, Random random) {
		this.df = dataFactory;
		this.random = random;
	}

	public IValueProvider create(SimField field) {
		if (field instanceof RandomBlob)
			return new BlobProvider(random, (RandomBlob) field);
		if (field instanceof RandomBoolean)
			return new BooleanProvider(random);
		if (field instanceof RandomChar)
			return new CharProvider(df);
		if (field instanceof Constant)
			return new ConstantProvider((Constant) field);
		if (field instanceof RandomDateTime)
			return new DateTimeProvider(random, (RandomDateTime) field);
		if (field instanceof RandomDouble)
			return new DoubleProvider(random, (RandomDouble) field);
		if (field instanceof RandomFloat)
			return new FloatProvider(random);
		if (field instanceof RandomInteger)
			return new IntegerProvider(random, (RandomInteger) field);
		if (field instanceof RandomLong)
			return new LongProvider(random);
		if (field instanceof RandomShort)
			return new ShortProvider(random, (RandomShort) field);
		if (field instanceof Address)
			return new AddressProvider(df);
		if (field instanceof AddressLine2)
			return new AddressLine2Provider(df, (AddressLine2) field);
		if (field instanceof BirthDate)
			return new BirthDateProvider(df);
		if (field instanceof BusinessName)
			return new BusinessNameProvider(df);
		if (field instanceof City)
			return new CityProvider(df);
		if (field instanceof EmailAddress)
			return new EmailAddressProvider(df);
		if (field instanceof FirstName)
			return new FirstNameProvider(df);
		if (field instanceof Item)
			return new ItemProvider(df, (Item) field);
		if (field instanceof LastName)
			return new LastNameProvider(df);
		if (field instanceof Name)
			return new NameProvider(df);
		if (field instanceof NumberText)
			return new NumberTextProvider(df, (NumberText) field);
		if (field instanceof Prefix)
			return new PrefixProvider(df, (Prefix) field);
		if (field instanceof RandomChars)
			return new RandomCharsProvider(df, (RandomChars) field);
		if (field instanceof RandomText)
			return new RandomTextProvider(df, (RandomText) field);
		if (field instanceof RandomWords)
			return new RandomWordsProvider(df, (RandomWords) field);
		if (field instanceof RandomWord)
			return new RandomWordProvider(df, (RandomWord) field);
		if (field instanceof StreetName)
			return new StreetNameProvider(df);
		if (field instanceof Sequence)
			return new SequenceProvider((Sequence) field);
		if (field instanceof StreetSuffix)
			return new StreetSuffixProvider(df);
		if (field instanceof Suffix)
			return new SuffixProvider(df, (Suffix) field);
		if (field instanceof Now)
			return new NowProvider();
		if (field instanceof Regex)
			return new RegexProvider((Regex) field);
		return null;
	}
}
