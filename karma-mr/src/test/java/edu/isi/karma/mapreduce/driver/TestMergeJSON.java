package edu.isi.karma.mapreduce.driver;

import org.apache.hadoop.io.Text;
import org.junit.Assert;
import org.junit.Test;

import edu.isi.karma.mapreduce.function.MergeJSON;

public class TestMergeJSON {
	@Test
	public void testMerge() {
		MergeJSON test = new MergeJSON();
		String a = " {\"syll:twitterId\":\"caknoblock\",\"@type\":\"http://lod.isi.edu/ontology/syllabus/Person\",\"foaf:homepage\":{\"@type\":\"http://xmlns.com/foaf/0.1/Document\",\"@id\":\"http://www.isi.edu/~knoblock\"},\"foaf:name\":\"Craig Knoblock\",\"foaf:lastName\":\"Knoblock\",\"@id\":\"http://lod.isi.edu/cs548/person/Knoblock\",\"id\":\"http://lod.isi.edu/cs548/person/Knoblock\",\"foaf:depiction\":{\"@type\":\"http://xmlns.com/foaf/0.1/Image\",\"@id\":\"http://www.isi.edu/integration/people/knoblock/img/CraigKnoblock.jpg\",\"foaf:depicts\":\"<http://lod.isi.edu/cs548/person/Knoblock>\"},\"foaf:title\":\"Prof\",\"foaf:mbox\":\"mailto:knoblock@isi.edu\"}";
		String b = " {\"rdfs:label\":\"knoblock@isi.edu\",\"@type\":\"http://www.w3.org/2002/07/owl#Thing\",\"@id\":\"mailto:knoblock@isi.edu\",\"id\":\"mailto:knoblock@isi.edu\"}";
		Text result = test.evaluate(new Text(a), new Text(b), new Text("foaf:mbox"));
		String expected = "{\"id\":\"http://lod.isi.edu/cs548/person/Knoblock\",\"syll:twitterId\":\"caknoblock\",\"@type\":\"http://lod.isi.edu/ontology/syllabus/Person\",\"foaf:homepage\":{\"@type\":\"http://xmlns.com/foaf/0.1/Document\",\"@id\":\"http://www.isi.edu/~knoblock\"},\"foaf:lastName\":\"Knoblock\",\"foaf:name\":\"Craig Knoblock\",\"foaf:depiction\":{\"@type\":\"http://xmlns.com/foaf/0.1/Image\",\"@id\":\"http://www.isi.edu/integration/people/knoblock/img/CraigKnoblock.jpg\",\"foaf:depicts\":\"<http://lod.isi.edu/cs548/person/Knoblock>\"},\"@id\":\"http://lod.isi.edu/cs548/person/Knoblock\",\"foaf:title\":\"Prof\",\"foaf:mbox\":{\"id\":\"mailto:knoblock@isi.edu\",\"rdfs:label\":\"knoblock@isi.edu\",\"@type\":\"http://www.w3.org/2002/07/owl#Thing\",\"@id\":\"mailto:knoblock@isi.edu\"}}";
		Assert.assertEquals(result.toString(), expected);
	}
	
	@Test
	public void testMerge2() {
		MergeJSON test = new MergeJSON();
		String a = "{\r\n    \"@type\": \"http://dig.isi.edu/ontology/URLEntity\",\r\n    \"dig:snapshot\": {\r\n        \"dig:mentionsPersonAge\": \"24\",\r\n        \"schema:dateCreated\": \"2014-02-28T16:57:00\",\r\n        \"dig:hasTitlePart\": {\r\n            \"@type\": \"http://schema.org/WebPageElement\",\r\n            \"schema:text\": \"|\u2665| __ UNDENiABLE LATiNA HOTTiE|\u2605| 1OOhh 160hr |\u2605| RAiNY DAY SPECiALS __ |\u2665| - 24\",\r\n            \"@id\": \"https://karmadigstorage.blob.core.windows.net/arch/churl/20140301/losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518/title\"\r\n        },\r\n        \"dig:hasBodyPart\": {\r\n            \"@type\": \"http://schema.org/WebPageElement\",\r\n            \"schema:text\": \"\\r\\n      \\r\\n            \\r\\n      \\r\\n      \\r\\n      \\r\\n        \\r\\n          \\r\\n          \\r\\n            You'll love my curvy figure, delicious booty, mesmerizing eyes and beautiful smile. One of my biggest pleasures is providing an unrushed experience that is unpredictable, sensual & all about YOU.\u00A0\\n\\nLatina/German\u00A0\\n5'4 135 36'c\u00A0\\n !\u00A0\\n\\nincall only\\n1OO specials \\nfetish friendly\\n\\nLana Lane\\n8O5-253-6469\\r\\n          \\r\\n        \\r\\n          \\r\\n    \",\r\n            \"@id\": \"https://karmadigstorage.blob.core.windows.net/arch/churl/20140301/losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518/body\"\r\n        },\r\n        \"dig:cacheUrl\": \"https://karmadigstorage.blob.core.windows.net/arch/churl/20140301/losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518\",\r\n        \"dig:preferredIdentifier\": {\r\n            \"rdfs:label\": \"38317518\",\r\n            \"@type\": \"http://dig.isi.edu/ontology/Identifier\",\r\n            \"@id\": \"http://dig.isi.edu/data/backpage/38317518/identifier/sid\"\r\n        },\r\n        \"schema:url\": \"http://losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518\",\r\n        \"@type\": \"http://schema.org/WebPage\",\r\n        \"dig:primaryLocation\": {\r\n            \"@type\": \"http://schema.org/Place\",\r\n            \"schema:iataCode\": \"LAX\",\r\n            \"@id\": \"http://dig.isi.edu/data/iata/lax\"\r\n        },\r\n        \"dig:mentionsPlace\": {\r\n            \"rdfs:label\": \"Los Angeles, Southbay. Lax area 4O5/1O5 fwy close\",\r\n            \"@type\": \"http://schema.org/Place\",\r\n            \"@id\": \"http://dig.isi.edu/data/place/lax/1o5_4o5_angeles_area_close_fwy_lax_los_southbay\"\r\n        },\r\n        \"@id\": \"https://karmadigstorage.blob.core.windows.net/arch/churl/20140301/losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518\",\r\n        \"dig:hasImagePart\": [\r\n            {\r\n                \"dig:cacheUrl\": \"http://studio.isi.edu/arch/data/escort/20140301/images1.backpage.com/imager/u/medium/115450048/blue.jpg\",\r\n                \"schema:url\": \"http://images1.backpage.com/imager/u/medium/115450048/blue.jpg\",\r\n                \"@type\": \"http://schema.org/ImageObject\",\r\n                \"@id\": \"http://images1.backpage.com/imager/u/medium/115450048/blue.jpg\"\r\n            },\r\n            {\r\n                \"dig:cacheUrl\": \"http://studio.isi.edu/arch/data/escort/20140301/images1.backpage.com/imager/u/medium/115450050/213-1.jpg\",\r\n                \"schema:url\": \"http://images1.backpage.com/imager/u/medium/115450050/213-1.jpg\",\r\n                \"@type\": \"http://schema.org/ImageObject\",\r\n                \"@id\": \"http://images1.backpage.com/imager/u/medium/115450050/213-1.jpg\"\r\n            },\r\n            {\r\n                \"dig:cacheUrl\": \"http://studio.isi.edu/arch/data/escort/20140301/images2.backpage.com/imager/u/medium/115450046/DA-C22524D15BD4_IMG_20140108_141145.jpg\",\r\n                \"schema:url\": \"http://images2.backpage.com/imager/u/medium/115450046/DA-C22524D15BD4_IMG_20140108_141145.jpg\",\r\n                \"@type\": \"http://schema.org/ImageObject\",\r\n                \"@id\": \"http://images2.backpage.com/imager/u/medium/115450046/DA-C22524D15BD4_IMG_20140108_141145.jpg\"\r\n            },\r\n            {\r\n                \"dig:cacheUrl\": \"http://studio.isi.edu/arch/data/escort/20140301/images3.backpage.com/imager/u/medium/115450047/992-F92D-45AC-C50BC61716DD_asdfghjkl.jpg\",\r\n                \"schema:url\": \"http://images3.backpage.com/imager/u/medium/115450047/992-F92D-45AC-C50BC61716DD_asdfghjkl.jpg\",\r\n                \"@type\": \"http://schema.org/ImageObject\",\r\n                \"@id\": \"http://images3.backpage.com/imager/u/medium/115450047/992-F92D-45AC-C50BC61716DD_asdfghjkl.jpg\"\r\n            },\r\n            {\r\n                \"dig:cacheUrl\": \"http://studio.isi.edu/arch/data/escort/20140301/images3.backpage.com/imager/u/medium/115450049/nm_.jpg\",\r\n                \"schema:url\": \"http://images3.backpage.com/imager/u/medium/115450049/nm_.jpg\",\r\n                \"@type\": \"http://schema.org/ImageObject\",\r\n                \"@id\": \"http://images3.backpage.com/imager/u/medium/115450049/nm_.jpg\"\r\n            }\r\n        ]\r\n    },\r\n    \"@id\": \"http://losangeles.backpage.com/FemaleEscorts/undeniable-latina-hottie-1oohh-160hr-rainy-day-specials-_-24/38317518\"\r\n}";
		String b = "{\r\n    \"@type\": \"http://schema.org/Place\",\r\n    \"schema:geo\": {\r\n        \"schema:longitude\": \"-118.408075\",\r\n        \"@type\": \"http://schema.org/GeoCoordinates\",\r\n        \"schema:latitude\": \"33.942536\",\r\n        \"@id\": \"http://dig.isi.edu/data/iata/lax/geo\"\r\n    },\r\n    \"@id\": \"http://dig.isi.edu/data/iata/lax\",\r\n    \"schema:address\": {\r\n        \"schema:addressCountry\": {\r\n            \"rdfs:label\": \"United States\",\r\n            \"@type\": \"http://schema.org/Country\",\r\n            \"@id\": \"http://dig.isi.edu/data/country/unitedstates\"\r\n        },\r\n        \"schema:addressLocality\": \"Los Angeles\",\r\n        \"@type\": \"http://schema.org/PostalAddress\",\r\n        \"@id\": \"http://dig.isi.edu/data/iata/lax/postaladdress\"\r\n    }\r\n}";
		Text result = test.evaluate(new Text(a), new Text(b), new Text("dig:snapshot/dig:primaryLocation"));
	}
}